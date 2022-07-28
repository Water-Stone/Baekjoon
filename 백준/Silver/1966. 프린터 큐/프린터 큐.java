import java.io.*;
import java.util.StringTokenizer;

class MyQueue {
    int[] arr;
    int front = 0;
    int rear;
    int timesOfPrints = 0;
    int idxM;

    public MyQueue(int N, int M) {
        this.rear = N + 1;
        this.arr = new int[this.rear];
        this.idxM = this.front + M + 1;
    }

    public void initQueue(int idx, int num) {
        this.arr[this.front + 1 + idx] = num;
    }

    public boolean isEmpty() {
        return (this.front == this.rear);
    }

    public boolean isMostImportant() {
        for (int i = this.front + 2; i < this.rear; i++) {
            if (this.peek() < this.arr[i]) {
                return false;
            }
        }
        return true;
    }

    public int peek() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.arr[this.front + 1];
    }

    public int dequeue() {
        if (this.isEmpty()) {
            return -1;
        }
        this.timesOfPrints++;
        if(this.front + 1 == this.idxM){
            return 100;
        }
        int temp = this.arr[this.front + 1];
        this.front++;
        return temp;
    }

    public void leftShift() {
        if(this.isEmpty()){
            return;
        }
        int temp = this.arr[this.front + 1];
        for (int i = this.front + 2; i < this.rear; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.arr[this.rear - 1] = temp;

        if(this.idxM == this.front + 1){
            this.idxM = this.rear - 1;
        }else{
            idxM--;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            MyQueue queue = new MyQueue(N,M);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.initQueue(j, Integer.parseInt(st.nextToken()));
            }

            while(true){
                if(queue.isMostImportant()){
                    if(queue.dequeue() == 100){
                        bw.write(queue.timesOfPrints + "\n");
                        break;
                    }
                }else {
                    queue.leftShift();
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
