import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] matrix = new int[N * N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i * N + j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        System.out.println(divideAndConquer(matrix));
    }

    private static int divideAndConquer(int[] oriMatrix) {
        if (oriMatrix.length == 4) {
            Arrays.sort(oriMatrix);
            return oriMatrix[2];
        }

        int oriN = (int) Math.sqrt(oriMatrix.length);
        int dividedN = oriN >> 1;
        int[] dividedMatrix = new int[dividedN * dividedN];
        for (int i = 0; i < dividedN; i++) {
            for (int j = 0; j < dividedN; j++) {
                int[] temp = new int[4];
                int p = i << 1;
                int q = j << 1;
                temp[0] = oriMatrix[p * oriN + q];
                temp[1] = oriMatrix[p * oriN + q + 1];
                temp[2] = oriMatrix[(p + 1) * oriN + q];
                temp[3] = oriMatrix[(p + 1) * oriN + q + 1];
                dividedMatrix[i * dividedN + j] = divideAndConquer(temp);
            }
        }
        return divideAndConquer(dividedMatrix);
    }
}
