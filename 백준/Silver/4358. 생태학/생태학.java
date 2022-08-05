import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int cnt = 0;
        for (; cnt < 1000000; cnt++) {
            String s = br.readLine();
            if (s == null || s.equals(""))
                break;

            map.put(s, map.getOrDefault(s, 0) + 1);

            if (map.keySet().size() > 10000)
                break;
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int i = 0; i < map.size(); i++) {
            String cur = keys.get(i);
            sb.append(cur).append(" ");
            double rate = (map.get(cur) / (double) cnt) * 100;
            sb.append(String.format("%.4f", rate)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
