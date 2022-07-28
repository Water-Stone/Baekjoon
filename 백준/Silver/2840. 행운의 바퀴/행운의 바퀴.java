import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = "?";
        }

        ArrayList<String> onBoard = new ArrayList<>();

        boolean isNotExist = false;
        int curr_idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            String alphabet = st.nextToken();

            if (arr[(curr_idx + S) % N].equals("?")) {
                if(onBoard.contains(alphabet)){
                    isNotExist = true;
                    break;
                }
                arr[(curr_idx + S) % N] = alphabet;
                onBoard.add(alphabet);
            } else if (!arr[(curr_idx + S) % N].equals(alphabet)) {
                isNotExist = true;
                break;
            }
            curr_idx = (curr_idx + S) % N;
        }

        printResult(arr, curr_idx, isNotExist);
        br.close();
    }

    private static void printResult(String[] arr, int idx, boolean flag) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int temp_idx = idx;
        if (flag) {
            bw.write("!");
        } else {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[temp_idx]);
                temp_idx--;
                if (temp_idx < 0)
                    temp_idx = arr.length - 1;
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
