import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();
        board = new char[N][N];

        drawStars(N, 0, 0, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void drawStars(int N, int r, int c, boolean isBlank) {
        if (isBlank) {
            for (int i = r; i < r + N; i++) {
                for (int j = c; j < c + N; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            board[r][c] = '*';
            return;
        }

        int cnt = 0;
        for (int i = r; i < r + N; i += N / 3) {
            for (int j = c; j < c + N; j += N / 3) {
                drawStars(N / 3, i, j, ++cnt == 5);
            }
        }
    }
}
