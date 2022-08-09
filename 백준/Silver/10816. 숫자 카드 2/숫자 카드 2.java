import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        int[] numbers = new int[map.size()];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            numbers[k] = entry.getKey();
            k++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        loop:
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int lo = 0;
            int hi = numbers.length - 1;

//            sb.append("\n").append(target).append("...");

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (target < numbers[mid]) hi = mid - 1;
                else if (target > numbers[mid]) lo = mid + 1;
                else if (target == numbers[mid]) {
                    sb.append(map.get(target)).append(" ");
                    continue loop;
                }
            }
            sb.append(0).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
