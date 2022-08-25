import java.io.*;

public class Main {
    static int[] board;
    static int cnt, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        br.close();

        cnt = 0;
        board = new int[N];

        nQueen(0);
        System.out.println(cnt);
    }

    private static void nQueen(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[row] = i;

            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }
    }

    private static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i]))
                return false;
        }
        return true;
    }

}
