import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        conquer(arr);
        System.out.println(sb);
    }

    private static void conquer(int[][] arr) {
        if (isAllSame(arr)) {
            int info = arr[0][0];
            sb.append(info);
            return;
        }

        int half = arr.length / 2;

        for (int i = 1; i <= 4; i++) {
            if (i == 1) sb.append("(");
            conquer(divide(arr, i));
            if (i == 4) sb.append(")");
        }

    }

    private static int[][] divide(int[][] arr, int site) {
        int half = arr.length / 2;

        int[][] res = new int[half][half];

        int i_start = 0, i_end = arr.length;
        int j_start = 0, j_end = arr.length;
        switch (site) {
            case 1:
                i_end = half;
                j_end = half;
                break;
            case 2:
                i_end = half;
                j_start = half;
                break;
            case 3:
                i_start = half;
                j_end = half;
                break;
            case 4:
                i_start = half;
                j_start = half;
                break;
        }

        for (int i = i_start; i < i_end; i++) {
            for (int j = j_start; j < j_end; j++) {
                res[i % half][j % half] = arr[i][j];
            }
        }
        return res;
    }

    private static boolean isAllSame(int[][] arr) {
        if (arr.length == 1) return true;

        int info = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != info)
                    return false;
            }
        }
        return true;
    }
}
