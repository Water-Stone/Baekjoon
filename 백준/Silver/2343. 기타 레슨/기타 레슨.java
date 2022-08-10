import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] videos = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, videos[i]);
        }

        int lo = maxValue;
        int hi = 10000 * N;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int cnt = 1;
            int sum = 0;

            for(int i = 0; i < N; i++){
                sum += videos[i];
                if(sum > mid){
                    sum = videos[i];
                    cnt++;
                }
            }

            if(cnt <= M){
                hi = mid;
            }else{
                lo = mid + 1;
            }

//            if (innerSearch(mid) <= M) {
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
        }

        System.out.println(lo);
        br.close();
    }

//    private static int innerSearch(int midValue) {
//        int cnt = 1;
//        int sum = 0;
//
//        int currIdx = 0;
//        int loIdx;
//        int hiIdx;
//
//        for (; currIdx < videos.length; currIdx = loIdx) {
//            loIdx = currIdx;
//            hiIdx = videos.length;
//            while (loIdx < hiIdx) {
//                int midIdx = (loIdx + hiIdx) / 2;
//
//                for (int i = currIdx; i <= midIdx; i++) {
//                    sum += videos[i];
//                }
//
//                if (sum <= midValue) {
//                    loIdx = midIdx + 1;
//                } else {
//                    hiIdx = midIdx;
//                }
//                sum = 0;
//            }
//            cnt++;
//        }
//
//        return --cnt;
//    }
}
