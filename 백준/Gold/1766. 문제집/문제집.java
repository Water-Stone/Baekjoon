import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N + 1];
        List<Integer>[] link = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a].add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                priorityQueue.offer(i);
        }

        while (!priorityQueue.isEmpty()) {
            int curr = priorityQueue.poll();
            sb.append(curr).append(" ");

            for (int next : link[curr]) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    priorityQueue.offer(next);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
