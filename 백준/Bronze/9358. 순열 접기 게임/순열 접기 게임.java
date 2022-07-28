import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

//    public static void main(String[] args) {
//        Main.solution();
//    }

    //    private static void solution() {
    public static void main(String[] args) {
        int numOfTestCases = 0;
//        System.out.print("TEST CASES: ");
        numOfTestCases = sc.nextInt();
        boolean[] winnerList = new boolean[numOfTestCases];

        for (int t = 0; t < numOfTestCases; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];


            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }


//            for (int i=0;i<N;i++){
//                System.out.printf("%d, ", arr[i]);
//            }
//            System.out.println();

//            for (int i = 0; i < N; i++) {
//                if (rand.nextBoolean()) {
//                    arr[i] = rand.nextInt();
//                } else {
//                    arr[i] = rand.nextInt() * (-1);
//                }
//            }

            winnerList[t] = whoWin(fold(arr));
        }

        for (int t = 0; t < numOfTestCases; t++) {
            System.out.printf("Case #%d: ", t + 1);
            if (winnerList[t]) {
                System.out.print("Alice\n");
            } else {
                System.out.print("Bob\n");
            }
        }
    }

    private static int[] fold(int[] arr) {
        if (arr.length == 2) {
            return arr;
        }

        if (arr.length % 2 != 0) {
            int N = (Math.round((float) arr.length / (float) 2));
            int[] res = new int[N];
            for (int i = 0; i < N - 1; i++) {
                res[i] = arr[i] + arr[arr.length - (i + 1)];
            }
            res[N - 1] = arr[N - 1] * 2;
            return fold(res);
        } else {
            int N = arr.length / 2;
            int[] res = new int[N];
            for (int i = 0; i < N - 1; i++) {
                res[i] = arr[i] + arr[arr.length - (i + 1)];
            }
            return fold(res);
        }
    }

    private static boolean whoWin(int[] arr) {
        if (arr[0] > arr[1]) {
            return true;
        } else {
            return false;
        }
    }
}
