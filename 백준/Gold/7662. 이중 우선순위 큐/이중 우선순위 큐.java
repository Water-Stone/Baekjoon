import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            TreeMap<Integer, Integer> map = new TreeMap<>();

            int K = Integer.parseInt(br.readLine());
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
//                    maxHeap.offer(n);
//                    minHeap.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (cmd == 'D') {
                    if(map.isEmpty()) continue;
                    int key;
                    if(n==1){
                        key = map.lastKey();
                    }else{
                        key = map.firstKey();
                    }
//                    switch (n) {
//                        case 1:
////                            maxHeap.poll();
//                            key = map.lastKey();
//                            break;
//                        case -1:
//                            key = map.firstKey();
////                            minHeap.poll();
////                            Set<Integer> tmpSet = new HashSet<>();
////                            while(maxHeap.size() > 1){
////                                tmpSet.add(maxHeap.poll());
////                            }
////                            maxHeap.poll();
////                            maxHeap.addAll(tmpSet);
//                            break;
//                    }
                    if(map.put(key, map.get(key) - 1) ==1)
                    map.remove(key);
                }
            }

            if(map.isEmpty())
                sb.append("EMPTY");
            else
                sb.append(map.lastKey() + " " + map.firstKey());

//            if(maxHeap.isEmpty())
//                sb.append("EMPTY");
//            else{
//                sb.append(maxHeap.poll()).append(" ");
//                sb.append(minHeap.poll());
//                while(maxHeap.size() > 1){
//                    maxHeap.poll();
//                }
//                sb.append(maxHeap.poll());
//            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
