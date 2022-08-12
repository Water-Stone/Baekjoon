import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(N + M);
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0;
        while (i < N && j < M) {
            if (A[i] > B[j]) list.add(B[j++]);
            else list.add(A[i++]);
        }

        while (i < N) list.add(A[i++]);
        while (j < M) list.add(B[j++]);

        for (int n : list)
            sb.append(n).append(" ");

        br.close();
        System.out.println(sb);
    }
}
