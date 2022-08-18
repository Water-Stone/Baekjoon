import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        if (K >= N) {
            System.out.println(0);
            return;
        }
        List<Integer> censors = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            censors.add(x);
        }
        Collections.sort(censors);

        List<Integer> distances = new ArrayList<>(N - 1);
        for (int i = 0; i < N - 1; i++)
            distances.add(censors.get(i + 1) - censors.get(i));
        distances.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i = K - 1; i < N - 1; i++) {
            sum += distances.get(i);
        }
        System.out.println(sum);
    }
}
