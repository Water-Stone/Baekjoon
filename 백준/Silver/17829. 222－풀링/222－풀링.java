import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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

    private static int divideAndConquer(int[] arr) {
        if (arr.length == 4) {
            Arrays.sort(arr);
            return arr[2];
        }

        int oriN = (int) Math.sqrt(arr.length);
        int dividedN = oriN >> 1;
        int[] tempMatrix = new int[dividedN * dividedN];
        for (int i = 0; i < dividedN; i++) {
            for (int j = 0; j < dividedN; j++) {
                int[] temp = new int[4];
                int k = i << 1;
                int p = j << 1;
                temp[0] = arr[k * oriN + p];
                temp[1] = arr[k * oriN + p + 1];
                temp[2] = arr[(k + 1) * oriN + p];
                temp[3] = arr[(k + 1) * oriN + p + 1];
                tempMatrix[i * dividedN + j] = divideAndConquer(temp);
            }
        }
        return divideAndConquer(tempMatrix);
    }
}
