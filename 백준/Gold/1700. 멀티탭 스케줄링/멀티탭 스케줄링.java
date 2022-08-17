import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> order = new ArrayList<>(K);
        HashSet<Integer> using = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(st.nextToken());
            order.add(n);
        }
        br.close();
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int n = order.get(i);

            if (!using.contains(n)) {
                if (using.size() < N) {
                    using.add(n);
                } else {
                    List<Integer> afterList = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (using.contains(order.get(j)) && !afterList.contains(order.get(j)))
                            afterList.add(order.get(j));
                    }

                    if (afterList.size() < N) {
                        for (int curr : using) {
                            if (!afterList.contains(curr)) {
                                using.remove(curr);
                                break;
                            }
                        }
                    } else {
                        using.remove(afterList.get(afterList.size() - 1));
                    }

                    using.add(n);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
