import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> chattedNames = new HashSet<>(N - 1);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.equals("ENTER")){
                chattedNames.clear();
            }else{
                if(chattedNames.add(str)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
