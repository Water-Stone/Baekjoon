import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class CircleQueue {
    public int[] arr;
    public int front = 0;
    public int rear;
    public int attempts = 0;

    CircleQueue(int size) {
        arr = new int[size + 1];
        rear = size;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
    }

//    public int getRear() {
//        return rear;
//    }
//
//    public int getFront() {
//        return front;
//    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

//    public boolean isFull(){
//        return (this.rear + 1) % this.arr.length == this.front;
//    }

//    public void enqueue(int data){
//        if(this.isFull()){
//            System.out.println("Queue is full!");
//            return;
//        }
//        this.rear = (this.rear + 1) % this.arr.length;
//        this.arr[this.rear] = data;
//    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return this.arr[(front + 1) % this.arr.length];
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void left_shift() {
        int temp = this.arr[front + 1];

        for (int i = front + 2; i < arr.length; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.arr[arr.length - 1] = temp;
//        System.out.println("\t<< LEFT SHIFTED <<");
        this.attempts++;
    }

    public void right_shift() {
        int temp = this.arr[rear];

        for (int i = rear; i > front + 1; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[front + 1] = temp;
//        System.out.println("\t>> RIGHT SHIFTED >>");
        this.attempts++;
    }

//    public void printCircleQueue(){
//        int start = (this.front + 1) % this.arr.length;
//        int end = (this.rear + 1) % this.arr.length;
//
//        for(int i = start;i != end; i = (i+1)%this.arr.length){
//            System.out.print(this.arr[i] + " ");
//        }
//        System.out.println();
//    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        CircleQueue cq = new CircleQueue(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
//            int m = br.read();

            while (true) {
                if (cq.peek().equals(m)) {
                    cq.dequeue();
//                    bw.write("dequeue.." + cq.dequeue() + "\n");
//                    bw.flush();
                    break;
                } else {
//                    m <= (cq.arr.length / 2)
                    int idx = 0;
                    for(int t = cq.front + 1; t<= cq.rear;t++){
                        if(cq.arr[t] == m){
                            idx = t;
                            break;
                        }
                    }
                    int mid = 1 + (cq.rear - cq.front) / 2 + cq.front;
//                    bw.write(idx + ", "+ mid + " = 1 + (" + cq.rear + " - " + cq.front + ") / 2 + " + cq.front);
//                    if (Arrays.binarySearch(cq.arr, m) <= mid) {
//                    if (Collections.singletonList(cq.arr).indexOf(m) <= mid) {
                    if (idx <= mid) {
                        cq.left_shift();
//                        bw.write("\t<< LEFT SHIFTED <<\n");
                    } else {
                        cq.right_shift();
//                        bw.write("\t>> RIGHT SHIFTED >>\n");
                    }
                }
            }
        }
        bw.write(cq.attempts + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
