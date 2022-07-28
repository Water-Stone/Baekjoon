import java.io.*;
import java.util.*;

class MyNode {
    int left;
    int right;

    public MyNode(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static List<MyNode>[] nodes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        List<String> list = new ArrayList<>(N*3);
        nodes = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 알파벳 가지고 뭐 할때면 아스키코드 활용해서 int 로 써먹으면 편하다
            int self = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            nodes[self].add(new MyNode(left, right));

//            list.add(self);
//            list.add(left);
//            list.add(right);

//            MyNode leftNode = null;
//            MyNode rightNode = null;
//            if(!left.equals(".")){
//                leftNode = new MyNode(left, null, null);
//            }
//            if(!right.equals(".")){
//                rightNode = new MyNode(right, null, null);
//            }
//
//            MyNode currNode = new MyNode(self, leftNode, rightNode);
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);
    }

    // '.' - 'A' = 19
    private static void preOrder(int idx) {
        for (MyNode node : nodes[idx]) {
            int left = node.left;
            int right = node.right;

            sb.append((char) (idx + 'A'));
            if (left != '.' - 'A') preOrder(left);
            if (right != '.' - 'A') preOrder(right);
        }
    }

    private static void inOrder(int idx) {
        for (MyNode node : nodes[idx]) {
            int left = node.left;
            int right = node.right;

            if (left != '.' - 'A') inOrder(left);
            sb.append((char) (idx + 'A'));
            if (right != '.' - 'A') inOrder(right);
        }
    }

    private static void postOrder(int idx) {
        for (MyNode node : nodes[idx]) {
            int left = node.left;
            int right = node.right;

            if (left != '.' - 'A') postOrder(left);
            if (right != '.' - 'A') postOrder(right);
            sb.append((char) (idx + 'A'));
        }
    }
}
