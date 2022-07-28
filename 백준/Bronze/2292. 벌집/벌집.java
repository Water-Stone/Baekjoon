import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int offset = 0;
        for(int i = 1;(6 * offset) + 1 < N;i++){
            cnt++;
            offset += i;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
