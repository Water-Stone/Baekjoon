import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    //    static int[][] field;
//    static boolean[][] visited;
    static int[] field;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
//            field = new int[M][N];
//            visited = new boolean[M][N];
            field = new int[M * N];
            visited = new boolean[M * N];

            int K = Integer.parseInt(st.nextToken());
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

//                field[x][y] = 1;
                field[(M * y) + x] = 1;
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[(M * i) + j] && field[(M * i) + j] == 1) {
                        searchNear(j, i);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void searchNear(int x, int y) {
        visited[(M * y) + x] = true;

        if (field[(M * y) + x] != 1)
            return;

        // 상
        if (y != N - 1) {
            if (field[(M * (y + 1)) + x] == 1 && !visited[(M * (y + 1)) + x]) {
                searchNear(x, y + 1);
            }
        }
        // 하
        if (y != 0) {
            if (field[(M * (y - 1)) + x] == 1 && !visited[(M * (y - 1)) + x]) {
                searchNear(x, y - 1);
            }
        }
        // 좌
        if (x != 0) {
            if (field[(M * y) + (x - 1)] == 1 && !visited[(M * y) + (x - 1)]) {
                searchNear(x - 1, y);
            }
        }
        // 우
        if (x != M - 1) {
            if (field[(M * y) + (x + 1)] == 1 && !visited[(M * y) + (x + 1)]) {
                searchNear(x + 1, y);
            }
        }
    }
}
