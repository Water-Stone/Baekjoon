import java.io.*;
import java.util.*;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>(N);
        for (int n = 0; n < N; n++) {
            set.add(br.readLine());
        }

        result = 0;
        for (int m = 0; m < M; m++) {
            String word = br.readLine();
            if (set.contains(word))
                result++;
        }
        System.out.println(result);
        br.close();
    }
}
