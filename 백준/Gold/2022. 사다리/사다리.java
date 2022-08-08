import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Float.parseFloat(st.nextToken());
        double y = Float.parseFloat(st.nextToken());
        final double c = Float.parseFloat(st.nextToken());

        double left = 0;
        double right = Math.min(x, y);

        while (right - left >= 0.001) {
            double d = (left + right) / 2;
            double hx = Math.sqrt(x * x - d * d);
            double hy = Math.sqrt(y * y - d * d);
            double curr_c = (hx * hy) / (hx + hy);

            if (curr_c >= c) left = d;
            else right = d;
        }

        System.out.printf("%.3f%n", right);
        br.close();
    }
}
