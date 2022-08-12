import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        List<Integer> list = new ArrayList<>(N+M);
        PriorityQueue<Integer> list = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            list.add(Integer.parseInt(st.nextToken()));

        br.close();

        StringBuilder sb = new StringBuilder();

        while (!list.isEmpty())
            sb.append(list.poll()).append(" ");

        System.out.println(sb);
    }
}
