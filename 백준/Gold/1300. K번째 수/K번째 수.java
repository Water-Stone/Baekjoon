import java.util.*;
import java.io.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        final long k = Long.parseLong(br.readLine());
        br.close();

        long lo = 1;
//        long hi = N * N;
        long hi = k;

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            if (getK(mid) < k) lo = mid + 1;
            else hi = mid;
        }
        System.out.println(lo);
    }

    private static long getK(long x) {
        // B[k] = x
        // 배열 B에서 x보다 작거나 같은 원소의 수 k

        long k = 0;
        for (long i = 1; i <= N; i++) {
            k += Math.min((x / i), N);
        }
        return k;
    }
}
