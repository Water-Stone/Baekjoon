import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] givenOrder;
    static boolean flag;
    static int N, g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for(int i=0;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        givenOrder = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            givenOrder[i] = Integer.parseInt(st.nextToken());
        }
        flag = true;

//        Stack<Integer> stack = new Stack<>();
//
//        boolean[] visited = new boolean[N + 1];
//
//        stack.push(1);
//
//
//        for(int i=1;i<N;i++){
//            int curr = stack.pop();
//            int maybeNext = givenOrder[i];
//
//            visited[curr] = true;
//
//            Set<Integer> set = new HashSet<>();
//            for(int next : graph[curr]){
//                if(visited[next])
//                    continue;
//                set.add(next);
//            }
//
//            if(set.isEmpty()){
//                stack.push(curr);
//                continue;
//            }
//
//            if(set.contains(maybeNext)){
//                stack.push(maybeNext);
//            }else{
//                flag = false;
//            }
//        }

        visited = new boolean[N + 1];
        g = 1;
        dfs(1);

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
        br.close();
    }

    static void dfs(int x){
        if(visited[x]) return;

        visited[x] = true;

        Set<Integer> set = new HashSet<>();
        for(int i : graph[x]){
            if(visited[i])
                continue;
            set.add(i);
        }

        if(set.isEmpty())
            return;

        if(set.contains(givenOrder[g])){
            dfs(givenOrder[g++]);
        }else{
            flag = false;
        }
    }
}