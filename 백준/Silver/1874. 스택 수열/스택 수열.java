import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
//        String result = "";
        StringBuilder sb = new StringBuilder();

        int temp_j=1;
        loop_arr:
        for (int i = 0; i < N; i++) {
            for (int j = temp_j; j <= N+1; j++) {
                if(stack.isEmpty()){
//                    bw.write("**push:\ti = " + i + ", j = " + j + "\n");
                    stack.push(j);
                    sb.append("+\n");
                }else{
                    if (stack.peek().equals(arr[i])) {
//                        bw.write("**pop:\ti = " + i + ", j = " + j + "\tpop = " + stack.pop() + "\n");
                        stack.pop();
                        sb.append("-\n");
                        temp_j = j;
                        break;
                    } else if (stack.peek() > arr[i]) {
//                        bw.write("**NO:\ti = " + i + ", j = " + j + "\n");
                        sb.delete(0,sb.length());
                        sb.append("NO"+"\n");
                        break loop_arr;
                    } else{
//                        bw.write("**push:\ti = " + i + ", j = " + j + "\n");
                        stack.push(j);
                        sb.append("+\n");
                    }
                }
            }
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
