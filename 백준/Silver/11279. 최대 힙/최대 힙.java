import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                if (maxHeap.isEmpty()) sb.append(0);
                else sb.append(maxHeap.poll());
                sb.append("\n");
            }
            else maxHeap.add(x);
        }
        System.out.println(sb);
        br.close();
    }
}
