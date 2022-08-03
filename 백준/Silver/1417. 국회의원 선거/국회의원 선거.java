import java.util.*;
import java.io.*;

class Candi {
    int number;
    int votes;

    public Candi(int number, int votes) {
        this.number = number;
        this.votes = votes;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        PriorityQueue<Integer> leaderBoard = new PriorityQueue<>();
//        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Candi> leaderBoard = new PriorityQueue<>((c1, c2) -> c2.votes - c1.votes);

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
//            map.put(i, x);
//            leaderBoard.add(x);
            leaderBoard.add(new Candi(i, x));
        }

        int result = 0;

        while (true) {
            if (!leaderBoard.isEmpty()) {
//                int mostVotes = leaderBoard.poll();
                Candi currLeader = leaderBoard.poll();

                if (currLeader.number == 1) {
                    if (leaderBoard.isEmpty())
                        break;
                    if (currLeader.votes == leaderBoard.peek().votes) {
                        result++;
                    }
                    break;
                }

                List<Candi> tmpCandis = new ArrayList<>();
                while (leaderBoard.peek().number != 1) {
                    tmpCandis.add(leaderBoard.poll());
                }
                Candi ds = leaderBoard.poll();
                leaderBoard.addAll(tmpCandis);

                ds.votes++;
                currLeader.votes--;

                leaderBoard.add(ds);
                leaderBoard.add(currLeader);
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}
