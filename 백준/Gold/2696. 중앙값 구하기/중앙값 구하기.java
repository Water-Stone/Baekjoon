import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();

            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");
            if (M <= 10) {
                st = new StringTokenizer(br.readLine());
                for (int m = 1; m <= M; m++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (m % 2 == 1) {
                        max.offer(num);
                    } else {
                        min.offer(num);
                    }

                    if (!max.isEmpty() && !min.isEmpty()) {
                        if (min.peek() < max.peek()) {
                            int a = max.poll();
                            int b = min.poll();
                            min.offer(a);
                            max.offer(b);
                        }
                    }

                    if (m % 2 == 1) {
                        sb.append(max.peek()).append(" ");
                    }
                }
                sb.append("\n");
            } else {
                int more = M % 10;
                for (int i = 1; i <= (M / 10); i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int m = 1; m <= 10; m++) {
                        int num = Integer.parseInt(st.nextToken());

                        if (m % 2 == 1) {
                            max.offer(num);
                        } else {
                            min.offer(num);
                        }

                        if (!max.isEmpty() && !min.isEmpty()) {
                            if (min.peek() < max.peek()) {
                                int a = max.poll();
                                int b = min.poll();
                                min.offer(a);
                                max.offer(b);
                            }
                        }

                        if (m % 2 == 1) {
                            sb.append(max.peek()).append(" ");
                        }
                    }
                    if (i % 2 == 0)
                        sb.append("\n");
                }
                if (more > 0) {
                    st = new StringTokenizer(br.readLine());
                    for (int i = 1; i <= more; i++) {
                        int num = Integer.parseInt(st.nextToken());

                        if (i % 2 == 1) {
                            max.offer(num);
                        } else {
                            min.offer(num);
                        }

                        if (!max.isEmpty() && !min.isEmpty()) {
                            if (min.peek() < max.peek()) {
                                int a = max.poll();
                                int b = min.poll();
                                min.offer(a);
                                max.offer(b);
                            }
                        }

                        if (i % 2 == 1) {
                            sb.append(max.peek()).append(" ");
                        }
                    }
                    sb.append("\n");
                }
            }

        }

        System.out.println(sb);
        br.close();
    }
}
