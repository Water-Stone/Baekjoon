import java.io.*;
import java.util.*;

public class Main {
    static int[] board;
    static boolean[] visited;
    static int N, M, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N * M];
        visited = new boolean[N * M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == '-') {
                    board[i * M + j] = 1;
                } else if (tmp.charAt(j) == '|') {
                    board[i * M + j] = 2;
                }
            }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(board[i * M + j]);
//            }
//            System.out.println();
//        }

        result = 0;

        for (int i = 0; i < N * M; i++) {
            if (!visited[i]) {
                // DFS
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    static void dfs(int idx) {
        if (visited[idx])
            return;

        visited[idx] = true;

        if (board[idx] == 1) {
            if (idx % M != (M - 1)) {
//                if(board[idx + 1] == 2)
//                    return;
                if (board[idx + 1] == 1 && !visited[idx + 1]) {
                    dfs(idx + 1);
                }
            }
//            else if (idx % M != 0) {
//                if (board[idx - 1] == 1 && !visited[idx - 1]) {
//                    dfs(idx - 1);
//                }
//            }
        } else if (board[idx] == 2) {
            if (idx < M * (N - 1)) {
                if(board[idx + M] == 1)
                    return;
                if (board[idx + M] == 2 && !visited[idx + M]) {
                    dfs(idx + M);
                }
            }
//            else if (idx >= M) {
//                if (board[idx - M] == 2 && !visited[idx - M]) {
//                    dfs(idx - M);
//                }
//            }
        }
    }
}
