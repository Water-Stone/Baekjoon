import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Long> pq = new PriorityQueue<>();

        long result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (M == 0) {
                result += Integer.parseInt(st.nextToken());
            } else {
                pq.offer((long) Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < M; i++) {
            long sum = pq.poll() + pq.poll();

            pq.offer(sum);
            pq.offer(sum);

            if (i == M - 1) {
                while (!pq.isEmpty()) {
                    result += pq.poll();
                }
                break;
            }
        }

        System.out.println(result);
        br.close();
    }
}
