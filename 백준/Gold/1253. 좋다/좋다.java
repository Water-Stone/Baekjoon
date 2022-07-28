import java.util.*;
import java.io.*;
//import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static int result;
    static int N;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
//        ArrayList<Integer> numbers = new ArrayList<>(N);
//        Stack<Integer> sumStack = new Stack<>();
//        Set<Integer> sumSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
//            int currNum =Integer.parseInt(st.nextToken());

//            if(!numbers.isEmpty()){
//                numbers.forEach((num)->{
//                    sumSet.add(num + currNum);   // HashSet add O(1)
//                });
//            }

//            numbers.add(currNum);   // ArrayList add O(1)
        }

//        System.out.println(sumSet);
//        System.out.println(numbers);

//        for(int i=0;i<N;i++){
//            if(sumSet.contains(numbers.get(i))){
//                result++;
//            }
//        }

        Arrays.sort(numbers);

//        AtomicInteger result = new AtomicInteger(0);

//        numbers.forEach((num)->{
//            if(sumSet.contains(num)){   // HashSet contains O(1)
//                result.getAndIncrement();
////                System.out.println(num);
//            }
//        });

//        for(int num : numbers){
//            if(sumSet.contains(num))    // HashSet contains O(1)
//                result.getAndIncrement();
//        }

        result = 0;
        for (int i = 0; i < N; i++) {
            binarySearch(i);
//                System.out.println(numbers[i]);
//            result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void binarySearch(int idx) {
//        if (arr.length <= 2 || idx < 2) {
//            return false;
//        }
        int value = numbers[idx];

//        int low = 0;
//        int high = idx - 1;
//        int mid = (low + high) / 2;

        int low = 0;
//        int mid = idx;
        int high = N -1;

        while(low < high){
            if(low == idx) low++;
            else if(high == idx) high--;
            else{
                if(value == numbers[low] + numbers[high]){
                    result++;
                    break;
                }else if(value > numbers[low] + numbers[high]){
                    low ++;
                }else high--;
            }
        }
//        while (true) {
//            for (int l = mid; l >= low; l--) {
//                for (int h = high; h > mid; h--) {
//                    if (arr[l] + arr[h] == value) {
//                        return true;
//                    }
//                }
//            }

//            for (int l = low; l < mid; l++) {
//                if (arr[l] + arr[l + 1] == value)
//                    return true;
//                for (int h = high; h > mid; h--) {
//                    if (arr[h] + arr[h - 1] == value)
//                        return true;
//                    if (arr[l] + arr[h] == value)
//                        return true;
//                }
//            }

//            return false;

//            if (low == high - 1)
//                return false;
//
//
//            if (value - arr[mid] >= arr[mid]) {
//                low = mid;
//            } else {
//                high = mid;
//            }
//            mid = (low + high) / 2;
//        }
    }
}
