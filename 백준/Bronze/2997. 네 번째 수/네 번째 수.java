import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
//        int[] arr = new int[3];
        int diff1, diff2;

        for(int i=0;i< 3;i++){
//            arr[i] = sc.nextInt();
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        diff1 = Math.abs(arr.get(0) - arr.get(1));
        diff2 = Math.abs(arr.get(1) - arr.get(2));

        if(diff1 == diff2){
            System.out.println(arr.get(2) + diff1);
        }else if(diff1 == diff2*2){
            System.out.println(arr.get(0)+diff2);
        }else if(diff2 == diff1*2){
            System.out.println(arr.get(1)+diff1);
        }

    }
}
