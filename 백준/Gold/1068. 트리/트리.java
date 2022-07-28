import java.io.*;
import java.util.*;

class Node{
//    int left;
//    int right;
    int self;
    int parent;

    public Node(int self, int parent) {
        this.self = self;
        this.parent = parent;
    }
}

public class Main {
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        int targetIdx = Integer.parseInt(br.readLine());
//        System.out.println(cntLeaf());
        deleteNode(targetIdx);
        System.out.println(cntLeaf());
    }

    static void deleteNode(int idx){
//        System.out.println("Delete - " + idx);
        for(Node node : nodes){
            if(node.parent == idx)
                deleteNode(node.self);
        }
        nodes[idx].parent = -2;
    }

    static boolean isLeaf(int idx){
        if(nodes[idx].parent == -2)
            return false;
        for(Node node : nodes){
            if (node.parent == idx)
                return false;
        }
        return true;
    }

    static int cntLeaf(){
        int cnt = 0;
        for(int i=0;i< nodes.length;i++){
            if(isLeaf(i)){
//                System.out.println(i + " is Leaf");
                cnt++;
            }
        }
        return cnt;
    }
}
