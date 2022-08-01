import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (List<Integer> list : graph) {
            list.sort(Collections.reverseOrder());
        }

        boolean[] visited = new boolean[N + 1];

        // DFS
        Stack<Integer> dfs_stack = new Stack<>();

//        visited[V] = true;
        dfs_stack.push(V);

        while (!dfs_stack.isEmpty()) {
            int idx = dfs_stack.pop();

            if(!visited[idx]){
                visited[idx] = true;
                sb.append(idx).append(" ");
            }


            for (int n = 0; n < graph[idx].size(); n++) {
                int num = graph[idx].get(n);
                if (!visited[num]) {
//                    visited[num] = true;
                    dfs_stack.push(num);
                }
            }
        }

        sb.append("\n");
        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        // BFS
        visited = new boolean[N + 1];

        Queue<Integer> bfs_queue = new LinkedList<>();

        visited[V] = true;
        bfs_queue.add(V);

        while (!bfs_queue.isEmpty()) {
            int idx = bfs_queue.poll();

            sb.append(idx).append(" ");

            for (int n : graph[idx]) {
                if (!visited[n]) {
                    visited[n] = true;
                    bfs_queue.add(n);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
