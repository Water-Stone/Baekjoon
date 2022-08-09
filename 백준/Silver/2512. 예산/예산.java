import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        int totalRequest = 0, max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int money = Integer.parseInt(st.nextToken());
            list.add(money);
            totalRequest += money;
            max = Math.max(max, money);
        }
        int totalBudget = Integer.parseInt(br.readLine());

        br.close();

        if (totalBudget >= totalRequest) {
            System.out.println(max);
            return;
        }

        int lo = 0;
        int hi = totalBudget + 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int sum = 0;
            for (int money : list) {
                sum += Math.min(money, mid);
            }

            if (sum <= totalBudget) lo = mid + 1;
            else hi = mid;
        }

        System.out.println(lo - 1);
    }
}
