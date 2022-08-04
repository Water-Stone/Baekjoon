import java.util.*;
import java.io.*;

class Jewel {
    int measure;
    int value;

    public Jewel(int measure, int value) {
        this.measure = measure;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.measure == o2.measure) return o2.value - o1.value;
            return o1.measure - o2.measure;
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;

        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < N && jewels[j].measure <= bags[i]) {
                pq.offer(jewels[j++].value);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }


//        PriorityQueue<Jewel> jewels_pq = new PriorityQueue<>((j1, j2) -> {
//            if(j1.measure == j2.measure)
//                return j2.value - j1.value;
//            return j1.measure - j2.measure;
//        });
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            jewels_pq.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//        }
//
//        PriorityQueue<Integer> bags_pq = new PriorityQueue<>();
//
//        for (int i = 0; i < K; i++) {
//            int c = Integer.parseInt(br.readLine());
//            bags_pq.offer(c);
//        }
//
//        Set<Integer> tempBags = new HashSet<>();
//
//        int result = 0;
//
//        loop:
//        while (!bags_pq.isEmpty() && !jewels_pq.isEmpty()) {
//            Jewel valuableJewel = jewels_pq.peek();
//            while (true) {
//                if (!bags_pq.isEmpty()) {
//                    if (valuableJewel.measure > bags_pq.peek()) {
//                        tempBags.add(bags_pq.poll());
//                    } else {
//                        break;
//                    }
//                } else {
//                    bags_pq.addAll(tempBags);
//                    jewels_pq.poll();
//                    continue loop;
//                }
//            }
//            bags_pq.poll();
//            bags_pq.addAll(tempBags);
//            result += valuableJewel.value;
//            jewels_pq.poll();
//        }


        System.out.println(result);
        br.close();
    }
}
