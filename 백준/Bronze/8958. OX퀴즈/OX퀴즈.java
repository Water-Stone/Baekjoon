import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(br.readLine());
        String[] strings = new String[numOfTestCases];

        for (int i = 0; i < numOfTestCases; i++) {
            strings[i] = br.readLine();
        }

        for (int i = 0; i < numOfTestCases; i++) {
            int result = 0;
            int correctStack = 0;
            for (String s : strings[i].split("")) {
                if (s.equals("O")) {
                    correctStack++;
                    result += correctStack;
                } else if (s.equals("X")) {
                    correctStack = 0;
                }
            }
            System.out.println(result);
        }
        br.close();
    }
}
