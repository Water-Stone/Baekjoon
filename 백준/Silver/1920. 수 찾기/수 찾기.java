import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(numbers);
        numbers = Arrays.stream(numbers).sorted().toArray();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (binarySearch(numbers, x))
                sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static boolean binarySearch(int[] numbers, int x) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (x < numbers[mid]) {
                hi = mid - 1;
            } else if (x > numbers[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return (x == numbers[lo]);
    }
}
