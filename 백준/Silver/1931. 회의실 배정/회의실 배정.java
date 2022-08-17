import java.io.*;
import java.util.*;

class Lecture {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> {
            if (l1.end == l2.end) return l1.start - l2.start;
            return l1.end - l2.end;
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(start, end));
        }
        br.close();

        int cnt = 0;
        int currTime = 0;
        while (!pq.isEmpty()) {
            Lecture currLecture = pq.poll();

            if (currLecture.start >= currTime) {
                currTime = currLecture.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
