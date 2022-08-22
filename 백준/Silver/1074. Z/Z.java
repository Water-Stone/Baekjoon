import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);
        cnt = 0;
        divideAndConquer(len, r, c);
        System.out.println(cnt);
    }

    private static void divideAndConquer(int len, int r, int c) {
        if (len == 1) {
            return;
        }

        int half = len >> 1;
        if (r < half && c < half) {
            divideAndConquer(half, r, c);
        } else if (r < half && c >= half) {
            cnt += (len * len >> 2);
            divideAndConquer(half, r, c % half);
        } else if (r >= half && c < half) {
            cnt += (len * len >> 2) * 2;
            divideAndConquer(half, r % half, c);
        } else {
            cnt += (len * len >> 2) * 3;
            divideAndConquer(half, r % half, c % half);
        }
    }
}
