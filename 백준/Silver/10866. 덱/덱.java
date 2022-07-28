import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new LinkedList<>();
        int num;

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dq.addFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dq.addLast(num);
                    break;
                case "pop_front":
                    if(!dq.isEmpty()){
                        num = dq.pollFirst();
                    }else{
                        num = -1;
                    }
                    bw.write(num + "\n");
                    break;
                case "pop_back":
                    if(!dq.isEmpty()){
                        num = dq.pollLast();
                    }else{
                        num = -1;
                    }
                    bw.write(num + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if(!dq.isEmpty()){
                        num = dq.peekFirst();
                    }else{
                        num = -1;
                    }
                    bw.write(num + "\n");
                    break;
                case "back":
                    if(!dq.isEmpty()){
                        num = dq.peekLast();
                    }else{
                        num = -1;
                    }
                    bw.write(num + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
