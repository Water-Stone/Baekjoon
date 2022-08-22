import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int prev = 0;
        int curr = 3;
        int mid = 3;
        for (; curr < N; mid++) {
            prev = curr;
            curr = curr * 2 + mid + 1;
        }

        while (true) {
            if (prev < N && N <= prev + mid) {
                N -= prev;
                break;
            }

            if (N <= prev) {
                curr = prev;
                mid--;
                prev = (curr - mid) / 2;
            } else {
                curr = prev;
                N -= (prev + mid);
                mid--;
                prev = (curr - mid) / 2;
            }
        }

        if (N == 1) System.out.println('m');
        else System.out.println('o');
    }
}
