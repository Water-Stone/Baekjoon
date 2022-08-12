import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> list = new ArrayList<>(); // 누적합
        list.add(0);
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                list.add(sum);
            }
        }
        final int numOfPrimes = list.size() - 1;

        int start = 0, end = 1;
        int cnt = 0;
        while (start < end && end <= numOfPrimes) {
            int sumOfPrimes = list.get(end) - list.get(start);

            if (sumOfPrimes >= N) {
                if (sumOfPrimes == N) cnt++;
                start++;
            } else end++;
        }

        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}