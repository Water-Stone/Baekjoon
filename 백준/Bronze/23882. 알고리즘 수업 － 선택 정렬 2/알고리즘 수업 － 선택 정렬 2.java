import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int cnt = 0;
        for (int i = N - 1; i > 0; i--) {
            int max = arr[i], maxIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            if (arr[i] < max) {
                int tmp = arr[i];
                arr[i] = max;
                arr[maxIdx] = tmp;
                cnt++;
                if (cnt == K) {
                    break;
                }
            }
        }

        if (cnt < K)
            sb.append(-1);
        else {
            for (int i = 0; i < N; i++)
                sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
