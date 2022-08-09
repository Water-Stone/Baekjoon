import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        List<Integer> lanLines = new ArrayList<>(K);
        int max = 0;
        for (int i = 0; i < K; i++) {
//            1 <= x <= Integer.MAX_VALUE;
            int x = Integer.parseInt(br.readLine());
            lanLines.add(x);
            max = Math.max(max, x);
        }

        long lo = 0;
        long hi = (long) max + 1;
        while (lo < hi) {
            long mid = (lo + hi) / 2;

            long sumOfCuts = 0;
            for (int line : lanLines) sumOfCuts += (long) line / mid;

            if (sumOfCuts >= N) {
                lo = mid + 1;
            } else hi = mid;
        }

        System.out.println(lo - 1);
        br.close();
    }
}
