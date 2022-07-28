import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(test(sc.nextInt()));
    }

    private static int test(int c1) {
        if(c1==1)return c1;
        int[] temp = new int[2];

        int n = 1;
        for (; temp[1] != 1 ; n++) {
            if (n == 1) {
                temp[0] = c1;
                temp[1] = C(c1);
            } else {
                temp[0] = temp[1];
                temp[1] = C(temp[0]);
            }
        }
        return n;
    }

    private static int C(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return 1 + num * 3;
        }
    }
}
