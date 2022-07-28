import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] matrix;
    static int[] parents;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        matrix = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            matrix[b].add(a);
//            matrix[a][b] = matrix[b][a] = 1;
        }

        Queue<Integer> works = new LinkedList<>();

        works.add(1);
        visited[1] = true;

        while (!works.isEmpty()) {
            int num = works.poll();
            for (int i : matrix[num]) {
                if (!visited[i]) {
                    visited[i] = true;
                    parents[i] = num;
                    works.add(i);
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
