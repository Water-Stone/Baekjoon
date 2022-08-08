import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>(N);
        long sumOfCuts;
        int high=0, low, mid;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            trees.add(num);
            if (high < num)
                high = num;
        }

//        Collections.sort(trees);

//        high = trees.get(N - 1);
        low = 0;

        while (low + 1 < high) {
            mid = (low + high) / 2;
            sumOfCuts = 0;

            for (int i = N - 1; i >= 0; i--)
                if (trees.get(i) > mid)
                    sumOfCuts += trees.get(i) - mid;
//                else break;

            if (sumOfCuts >= M) low = mid;
            else high = mid;
        }

        System.out.println(low);
        br.close();
    }
}