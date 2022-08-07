import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] og = new int[N];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            og[i] = num;
            map.put(num, i);
        }

        int cnt = 0;

        for (int i = N - 1; i > 0; i--) {
            Map.Entry<Integer, Integer> e = map.pollLastEntry();
            if (e.getValue() != i) {
                // swap
                og[e.getValue()] = og[i];
                map.put(og[i], e.getValue());
                og[i] = e.getKey();
                
                if (++cnt == K) {
                    sb.append(og[e.getValue()]).append(" ").append(og[i]);
                }

//                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                    if (entry.getValue() == i) {
//                        map.put(entry.getKey(), e.getValue());
//                        if (++cnt == K) {
//                            sb.append(entry.getKey()).append(" ").append(e.getKey());
//                            break loop;
//                        }
//                        break;
//                    }
//                }
            }
        }

        if (cnt < K)
            sb.append(-1);

        System.out.println(sb);
    }
}
