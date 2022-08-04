import java.io.*;
import java.util.*;

class Lecture {
    int s;
    int t;

    public Lecture(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> {
            if (l1.s == l2.s) return l1.t - l2.t;
            return l1.s - l2.s;
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.offer(new Lecture(s, t));
        }

        PriorityQueue<Integer> classroom = new PriorityQueue<>();
        classroom.offer(pq.poll().t);

        while(!pq.isEmpty()){
            Lecture currLecture = pq.poll();
            if(classroom.peek() <= currLecture.s) classroom.poll();
            classroom.offer(currLecture.t);
        }

        System.out.println(classroom.size());
        br.close();
    }
}
