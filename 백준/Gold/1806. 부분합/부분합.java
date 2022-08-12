import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        br.close();
        List<Integer> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));
        list.add(0);

        int start = 0, end = 0;
        int shortest = N + 2;
        int sum = 0;
        while (start <= end && end <= N) {
//            for (int i = start; i <= end; i++)
//                sum += list.get(i);

            if (sum >= S) {
                shortest = Math.min(shortest, end - start);
                sum -= list.get(start++);
            } else {
                sum += list.get(end++);
            }
        }

        bw.write((shortest == N + 2) ? String.valueOf(0) : String.valueOf(shortest));
        bw.flush();
        bw.close();
    }
}
