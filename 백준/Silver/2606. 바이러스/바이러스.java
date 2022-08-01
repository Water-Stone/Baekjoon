import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfComputers = Integer.parseInt(br.readLine()); // 1 ~ 100
        int numOfPairs = Integer.parseInt(br.readLine());

        List<Integer>[] network = new List[numOfComputers + 1];
        for (int i = 0; i < numOfComputers + 1; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < numOfPairs; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numOfComputers + 1];

        stack.push(1);
        visited[1] = true;

        int infected = 0;

        while (!stack.isEmpty()) {
            int i = stack.pop();

//            System.out.println(i + " - ");
            infected++;

            for (int node : network[i]) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
        System.out.println(infected - 1);
    }
}
