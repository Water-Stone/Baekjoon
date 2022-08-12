import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        br.close();
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;
        int start = 0, end = 0, sum;

        while (start < N && end < N) {
            sum = 0;
            for (int i = start; i <= end; i++)
                sum += list.get(i);

            if (sum == M) {
                start++;
                end++;
                cnt++;
                continue;
            }

            if (sum < M) end++;
            else start++;
        }

        System.out.println(cnt);
    }
}
