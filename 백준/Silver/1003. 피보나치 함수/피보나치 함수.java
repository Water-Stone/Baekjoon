import java.io.*;

public class Main {
    static int[][] cntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cntArr = new int[N + 1][2];
            fibonacci(N);
            sb.append(cntArr[N][0]).append(" ").append(cntArr[N][1]).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static void fibonacci(int n) {
        cntArr[0][0] = 1;
        cntArr[0][1] = 0;
        if (n == 0) return;

        cntArr[1][0] = 0;
        cntArr[1][1] = 1;
        if (n <= 1) return;

        for (int i = 2; i <= n; i++) {
            cntArr[i][0] = cntArr[i - 1][0] + cntArr[i - 2][0];
            cntArr[i][1] = cntArr[i - 1][1] + cntArr[i - 2][1];
        }
    }
}
