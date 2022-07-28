import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        solution();
    }

    private static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;
//        ArrayList<Integer> result = new ArrayList<>();

//        N = sc.nextInt();
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> listN = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
//        String[] strListN = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
//            listN.add(sc.nextInt());
//            StringTokenizer st = new StringTokenizer(str);
//            str = br.readLine();
            listN.add(Integer.parseInt(st.nextToken()));
//            listN.add(Integer.parseInt(strListN[i]));
        }
        Collections.sort(listN);


//        M = sc.nextInt();
        M = Integer.parseInt(br.readLine());
//        ArrayList<Integer> listM = new ArrayList<>();
//        int[] listM = new int[M];
        st = new StringTokenizer(br.readLine());
//        String[] strListM = br.readLine().split(" ");
        for (int i = 0; i < M; i++){
//            listN.add(sc.nextInt());
//            StringTokenizer st = new StringTokenizer(str);
//            str = br.readLine();
            int m = Integer.parseInt(st.nextToken());
//            listM.add(Integer.parseInt(strListM[i]));

            // Binary Search
            int first = 0;
            int last = N -1;
            boolean flag = false;
            while(first<=last){
                int mid = (first+last)/2;
                int target = listN.get(mid);

                if(target == m){
                    flag = true;
                    break;
                }

                if(target > m) {
                    last = mid - 1;
                }
                else {
                    first = mid + 1;
                }
            }
            if(flag) bw.write(1 + " ");
            else bw.write(0 + " ");
        }
        bw.flush();
        bw.close();
        br.close();

//        for (int i = 0; i < listM.size(); i++) {
//            for (int j = 0; j < listN.size(); j++) {
//                if (listN.contains(listM.get(i))) {
//                    result.add(1);
//                    break;
//                }
//                if (j == listN.size() - 1) {
//                    result.add(0);
//                }
//            }
//        }

//        for (int i = 0; i < result.size(); i++) {
////            System.out.print(result.get(i) + " ");
//            bw.write(result.get(i).toString() + " ");
//        }
    }
}
