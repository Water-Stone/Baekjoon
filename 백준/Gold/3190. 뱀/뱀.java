import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] board;
    static Deque<int[]> currSnakePos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];

        // K개의 사과를 board 위에 놓자.
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int posOfApple_row = Integer.parseInt(st.nextToken());
            int posOfApple_col = Integer.parseInt(st.nextToken());
            // 문제에서 '맨 위 맨 좌측이 1행 1열'이라고 주어짐. 인덱스로 사용하기 위해 1 빼줌.
            board[posOfApple_row - 1][posOfApple_col - 1] = true;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> moves = new LinkedHashMap<>(L);
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            moves.put(X, C);
        }

        currSnakePos = new ArrayDeque<>();
        currSnakePos.addFirst(new int[]{0, 0});
        // currDir = "RIGHT": 0, "DOWN": 1, "LEFT": 2, "UP": 3
        int currDir = 0;

        // the snake is moving
        int time = 0;
        while (move(currDir)) {
            // 시간 맞춰서 방향 전환
            time++;
            if (moves.containsKey(time)) {
                if (moves.get(time) == 'L') {
                    currDir--;
                    if (currDir < 0) currDir = 3;
                } else if (moves.get(time) == 'D') {
                    currDir++;
                    if (currDir > 3) currDir = 0;
                }
            }
        }

        System.out.println(time + 1);
        br.close();
    }

    static boolean move(int dir) {
        int[] pos = currSnakePos.peekFirst().clone();

        // 이동 방향에 따른 벽 체크
        switch (dir) {
            // "RIGHT": 0, "DOWN": 1, "LEFT": 2, "UP": 3
            case 0:
                if (pos[1] == N - 1) return false;
                pos[1]++;
                break;
            case 1:
                if (pos[0] == N - 1) return false;
                pos[0]++;
                break;
            case 2:
                if (pos[1] == 0) return false;
                pos[1]--;
                break;
            case 3:
                if (pos[0] == 0) return false;
                pos[0]--;
                break;
        }

        for (int[] snakeBody : currSnakePos) {
            if (snakeBody[0] == pos[0] && snakeBody[1] == pos[1])
                return false;
        }

        if (board[pos[0]][pos[1]]) {
            // isApple = true
            board[pos[0]][pos[1]] = false;
            currSnakePos.addFirst(pos);
        } else {
            // isApple = false
            currSnakePos.addFirst(pos);
            currSnakePos.pollLast();
        }

        return true;
    }
}
