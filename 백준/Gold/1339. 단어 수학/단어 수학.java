import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                map.put(c, (int) (map.getOrDefault(c, 0) + Math.pow(10, str.length() - 1 - j)));
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int num = 9;
        int sum = 0;
        for (int value : list)
            sum += value * num--;

        System.out.println(sum);
    }
}