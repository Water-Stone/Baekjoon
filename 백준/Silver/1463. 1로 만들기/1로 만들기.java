import java.io.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= Math.pow(10, 6)
        N = Integer.parseInt(br.readLine());
        br.close();
        dp = new int[N + 1];
        System.out.println(func(N));
    }

    private static int func(int n) {
        if (n <= 3) {
            if (n == 1) return 0;
            else return 1;
        }

        if (dp[n] != 0) return dp[n];

        if (n % 3 != 0 && n % 2 != 0) {
            dp[n] = func(n - 1) + 1;
        } else if (n % 6 == 0) {
            int tmp = func(n / 3);
            tmp = Math.min(tmp, func(n / 2));
            tmp = Math.min(tmp, func(n - 1));
            dp[n] = tmp + 1;
        } else if (n % 3 == 0) {
            int tmp = func(n / 3);
            tmp = Math.min(tmp, func(n - 1));
            dp[n] = tmp + 1;
        } else {
            int tmp = func(n / 2);
            tmp = Math.min(tmp, func(n - 1));
            dp[n] = tmp + 1;
        }

        return dp[n];
    }
}
