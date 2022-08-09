import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        lis[0] = seq[0];
        int idx = 1;

        for (int i = 1; i < N; i++) {
            if (lis[idx - 1] < seq[i]) {
                lis[idx++] = seq[i];
            } else if (lis[0] > seq[i]) {
                lis[0] = seq[i];
            } else {
                int temp = Arrays.binarySearch(lis, 0, idx, seq[i]);
                lis[temp < 0 ? -(temp + 1) : temp] = seq[i];
            }
        }
        System.out.println(idx);
    }
}
