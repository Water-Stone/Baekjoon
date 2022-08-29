import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cardPacks = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 1; i <= N; i++)
            cardPacks[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], cardPacks[j] + dp[i - j]);
        }

        System.out.println(dp[N]);
    }
}
