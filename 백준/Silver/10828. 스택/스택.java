import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        myStack mystack = new myStack();
        int N = Integer.parseInt(br.readLine());

//        StringBuilder order = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer order = new StringTokenizer(br.readLine(), " ");
            switch (order.nextToken()) {
                case "push":
                    mystack.push(Integer.parseInt(order.nextToken()));
                    break;
                case "pop":
                    bw.write(mystack.pop() + "\n");
                    break;
                case "size":
                    bw.write(mystack.size() + "\n");
                    break;
                case "empty":
                    bw.write(mystack.empty() + "\n");
                    break;
                case "top":
                    bw.write(mystack.top() + "\n");
                    break;
            }
//            order.setLength(0);
//            order.append(br.readLine());
//            if(String.valueOf(order).contains("push")){
//                int X = Integer.parseInt(Character.toString(order.charAt(order.indexOf("push") + 5)));
//                mystack.push(X);
//            }else if(String.valueOf(order).contains("pop")){
//                mystack.pop();
//            }else if(String.valueOf(order).contains("size")){
//                mystack.size();
//            } else if (String.valueOf(order).contains("empty")) {
//                mystack.empty();
//            } else if (String.valueOf(order).contains("top")) {
//                mystack.top();
//            }
        }
//        mystack.bw.close();
        bw.flush();
        bw.close();
        br.close();
    }
}

class myStack {
    ArrayList<Integer> innerList = new ArrayList<>();
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public myStack() {
    }

    public void push(int X) {
        this.innerList.add(X);
    }

    public int pop() {
        if (this.innerList.size() == 0) {
            return -1;
//            bw.write(-1 + "\n");
        } else {
            int r = this.innerList.get(this.innerList.size() - 1);
//            bw.write(this.innerList.get(this.innerList.size() - 1) + "\n");
            this.innerList.remove(this.innerList.size() - 1);
            return r;
//        System.out.println(this.innerList.get(this.innerList.size() - 1));
        }
//        bw.flush();
    }

    public int size() {
        return this.innerList.size();
//        bw.write(this.innerList.size() + "\n");
//        bw.flush();
    }

    public int empty() {
        if (this.innerList.size() == 0) {
            return 1;
//            bw.write(1 + "\n");
        } else {
            return 0;
//            bw.write(0 + "\n");
        }
//        bw.flush();
    }

    public int top() {
        if (this.innerList.size() == 0) {
//            bw.write(-1 + "\n");
            return -1;
        } else {
//            bw.write(this.innerList.get(this.innerList.size() - 1)+ "\n");
            return this.innerList.get(this.innerList.size() - 1);
        }
//        bw.flush();
    }
}