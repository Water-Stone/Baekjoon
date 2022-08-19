import java.io.*;
import java.util.*;

public class Main {
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] papers = new int[N * N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i * N + j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        white = 0;
        blue = 0;
        divideAndConquer(papers);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divideAndConquer(int[] oriPapers) {
        int oriN = (int) Math.sqrt(oriPapers.length);

        int color = oriPapers[0];
        boolean isAllSameColor = true;
        for (int i = 0; i < oriN; i++) {
            for (int j = 0; j < oriN; j++) {
                if (oriPapers[i * oriN + j] != color) {
                    isAllSameColor = false;
                    break;
                }
            }
        }
        if (isAllSameColor) {
            if (color == 0) white++;
            else if (color == 1) blue++;
            return;
        }

        int dividedN = oriN >> 1;
        for (int K = 0; K < 4; K++) {
            int[] dividedMatrix = new int[dividedN * dividedN];
            int i_start = 0, i_end = 0, j_start = 0, j_end = 0;
            switch (K) {
                case 0:
                    i_start = 0;
                    i_end = dividedN;
                    j_start = 0;
                    j_end = dividedN;
                    break;
                case 1:
                    i_start = 0;
                    i_end = dividedN;
                    j_start = dividedN;
                    j_end = oriN;
                    break;
                case 2:
                    i_start = dividedN;
                    i_end = oriN;
                    j_start = 0;
                    j_end = dividedN;
                    break;
                case 3:
                    i_start = dividedN;
                    i_end = oriN;
                    j_start = dividedN;
                    j_end = oriN;
                    break;
            }

            for (int i = i_start; i < i_end; i++) {
                for (int j = j_start; j < j_end; j++) {
                    dividedMatrix[(i - i_start) * dividedN + (j - j_start)]
                            = oriPapers[i * oriN + j];
                }
            }

            divideAndConquer(dividedMatrix);
        }

    }
}
