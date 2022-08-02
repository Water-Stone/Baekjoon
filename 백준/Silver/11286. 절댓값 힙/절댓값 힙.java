import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minAbsHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else {
                    return (o1 >= o2) ? 1 : -1;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (minAbsHeap.isEmpty()) sb.append(0);
                else sb.append(minAbsHeap.poll());
                sb.append("\n");
            } else {

                minAbsHeap.add(x);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
