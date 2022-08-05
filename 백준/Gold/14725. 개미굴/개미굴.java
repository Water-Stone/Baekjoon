import java.io.*;
import java.util.*;

class Node {
    String foodName;
    HashSet<Node> children;
    int level;

    public Node() {
        this.children = new HashSet<>();
    }

    public Node(String foodName, int level) {
        this.foodName = foodName;
        this.children = new HashSet<>();
        this.level = level;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(StringTokenizer st, int K) {
        Node cur = root;

        loop:
        for (int i = 0; i < K; i++) {
            String str = st.nextToken();
            if (!cur.children.isEmpty()) {
                for (Node node : cur.children) {
                    if (node.foodName.equals(str)) {
                        cur = node;
                        continue loop;
                    }
                }
            }
            Node next = new Node(str, i);
            cur.children.add(next);
            cur = next;
        }
    }

    public StringBuilder printTrie(Node cur) {
        StringBuilder sb = new StringBuilder();
        int level = cur.level;

        if (!cur.children.isEmpty()) {
            if (cur.children.size() != 1) {
                List<Node> childrenList = new ArrayList<>(cur.children);
                childrenList.sort(Comparator.comparing((node) -> node.foodName));
                for (int i = 0; i < cur.children.size(); i++) {
                    Node node = childrenList.get(i);
                    for (int n = 0; n < node.level; n++)
                        sb.append("--");
                    sb.append(node.foodName).append("\n").append(printTrie(node));
                }
            } else {
                Iterator<Node> it = cur.children.stream().iterator();
                Node node = it.next();
                for (int n = 0; n < node.level; n++)
                    sb.append("--");
                sb.append(node.foodName).append("\n").append(printTrie(node));
            }
        }

        return sb;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            trie.insert(st, K);
        }
        System.out.println(trie.printTrie(trie.root));
        br.close();
    }
}
