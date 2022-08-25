import java.io.*;
import java.util.*;

public class Main {
    static List<Character> chars;
    static int L, C;
    static Queue<String> sb_results = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new ArrayList<>(C);

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < C; i++)
            chars.add(st.nextToken().charAt(0));
        Collections.sort(chars);

        for (int i = 0; i < C - L + 1; i++)
            makePW(new StringBuilder(), i);

        while (!sb_results.isEmpty()) {
            bw.write(sb_results.poll());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void makePW(StringBuilder sb, int idx) {
        if (sb.length() == L) {
            if (!sb_results.contains(sb.toString()) && isPromising(sb))
                sb_results.add(sb.toString());
            return;
        }

        if (idx >= C) return;

        StringBuilder new_sb = new StringBuilder(sb);
        new_sb.append(chars.get(idx));

        for (int i = idx; i < C; i++) {
            makePW(new_sb, i + 1);
        }
    }

    private static boolean isPromising(StringBuilder sb) {
        int co = 0;
        int vo = 0;
        for (char c : sb.toString().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vo++;
            else co++;
        }

        return vo >= 1 && co >= 2;
    }
}
