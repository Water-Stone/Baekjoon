import java.util.*;
import java.io.*;

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.tFlag = true;
                return;
            }
        }
    }
}

class Node {
    HashMap<Character, Node> child;
    boolean tFlag;

    public Node() {
        this.child = new HashMap<>();
        this.tFlag = false;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
//            Trie trie = new Trie();
            boolean isConsistent = true;

            int N = Integer.parseInt(br.readLine());
            String[] strings = new String[N];
            for (int n = 0; n < N; n++) {
//                trie.insert(br.readLine());
                strings[n] = br.readLine();
            }
            Arrays.sort(strings);

            for (int i = 0; i < N - 1; i++) {
                if (strings[i + 1].startsWith(strings[i]))
                    isConsistent = false;
            }


            if (isConsistent) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
