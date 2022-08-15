import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        int totalSum = 0;
        int sum = 0;
        for (int time : list) {
            sum += time;
            totalSum += sum;
        }

        System.out.println(totalSum);
    }
}
