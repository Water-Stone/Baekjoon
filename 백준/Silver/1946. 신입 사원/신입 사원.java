import java.io.*;
import java.util.*;

//class Applicant {
//    int paper;
//    int interview;
//
//    public Applicant(int paper, int interview) {
//        this.paper = paper;
//        this.interview = interview;
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (N == 1) {
                sb.append(N).append("\n");
                continue;
            }
//            List<Applicant> list = new ArrayList<>(N);
            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
//                list.add(new Applicant(paper, interview));
                arr[paper] = interview;
            }
//            list.sort(Comparator.comparingInt(a -> a.paper));

//            int cnt_dropout = 0;
            int pivot = arr[1];
            int cnt_pass = 1;
            for (int i = 2; i <= N; i++) {
                if (arr[i] < pivot) {
                    cnt_pass++;
                    pivot = arr[i];
                }
            }

//            for (int i = 1; i <= N; i++) {
//                if(arr[i]==1) continue;
//                for (int j = i + 1; j <= N; j++) {
//                    if (arr[j] > arr[i]) {
//                        cnt_dropout++;
//                    } else {
//                        i = j;
//                        i--;
//                        break;
//                    }
//                }
//            }

//            for (int i = 0; i < N; i++) {
//                Applicant man = list.get(i);
//                if (man.paper != 1 && man.interview != 1) {
//                    for (int j = 0; j < i; j++) {
//                        if (list.get(j).interview < man.interview) {
//                            cnt_dropout++;
//                            break;
//                        }
//                    }
//                }
//            }

//            sb.append(N - cnt_dropout).append("\n");
            sb.append(cnt_pass).append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}
