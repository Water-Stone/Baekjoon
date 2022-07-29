import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int d = A - B;
        int offset = V - A;
        int days;
        if(offset == 0){
            days = 0;
        }else if(d>offset){
            days = 1;
        }else{
            days = (int)Math.ceil((double)offset / (double)d);
        }
        days++;

//        int currPos = 0;
//        int days = 0;
//        while (true) {
//            days++;
//            // 낮
//            currPos += A;
//
//            // 정상?
//            if(currPos >= V)
//                break;
//
//            // 밤
//            currPos -= B;
//        }

        System.out.println(days);
        br.close();
    }
}
