import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        br.close();

        int Z = (int) ((Y * 100) / X);

//        System.out.println(Z);
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int lo = 0;
        int hi = 1000000000;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int winRate = (int) (((Y + mid) * 100) / (X + mid));

            if (winRate != Z) hi = mid;
            else lo = mid + 1;
        }
        System.out.println(lo);
    }
}
