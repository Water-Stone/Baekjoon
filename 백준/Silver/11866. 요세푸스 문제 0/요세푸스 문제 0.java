import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = new int[N];
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; !queue.isEmpty(); ) {
            for (int j = 1; j < K; j++) {
                queue.offer(queue.poll());
            }
            result[i] = queue.poll();
            i++;
        }

        bw.write("<");
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1) {
                bw.write(result[i] + ", ");
            } else {
                bw.write(result[i] + ">\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
