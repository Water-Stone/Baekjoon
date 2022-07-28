import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 정점의 개수 N
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수 M

        visited = new boolean[N + 1];
        matrix = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            matrix[u][v] = matrix[v][u] = 1;
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                DFS(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void DFS(int idx) {
        visited[idx] = true;

        for (int i = 1; i < N + 1; i++) {
            if (matrix[idx][i] == 1 && !visited[i])
                DFS(i);
        }
    }
}
