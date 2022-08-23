import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();
        board = new char[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(board[i], ' ');
        }

        drawStars(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void drawStars(int N, int r, int c) {
        if (N == 1) {
            board[r][c] = '*';
            return;
        }

        int newN = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                drawStars(newN, r + (i * newN), c + (j * newN));
            }
        }
    }
}
