import java.io.*;
import java.util.*;

public class Main {
//    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
//            List<Integer> list_N = new ArrayList<>(N);
//            list = new ArrayList<>(N);
//            Set<Integer> set_N = new HashSet<>(N);
            Set<String> set = new HashSet<>(N);
            while (st.hasMoreTokens()) {
//                list_N.add(Integer.parseInt(st_N.nextToken()));
//                set_N.add(Integer.parseInt(st.nextToken()));
                set.add(st.nextToken());
            }
//            Collections.sort(list);


//            int M = Integer.parseInt(br.readLine());
            br.readLine();
            st = new StringTokenizer(br.readLine());
//            List<Integer> list_M = new ArrayList<>(M);
            while (st.hasMoreTokens()) {
//                list_M.add(Integer.parseInt(st_M.nextToken()));
                if(set.contains(st.nextToken())){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
//                int m = Integer.parseInt(st_M.nextToken());
//                sb.append(binarySearch(0,N-1,m)).append("\n");
//                if (list.contains(m)) {
//                    sb.append(1).append("\n");
//                } else {
//                    sb.append(0).append("\n");
//                }
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

//    private static int binarySearch(int low, int high, int num) {
//        int mid = (low + high) / 2;
//        int value = list.get(mid);
//
//        if(num == value){
//            return 1;
//        }else if(low==high){
//            return 0;
//        }
//
//        if (num < value) {
//            high = mid - 1;
//        }else{
//            low = mid + 1;
//        }
//        return binarySearch(low, high, num);
//    }
}
