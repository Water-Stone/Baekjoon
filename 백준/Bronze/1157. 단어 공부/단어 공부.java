import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.toUpperCase();

        int[] alphabets = new int[26];

        for (char c : str.toCharArray()) {
            alphabets[c - 'A']++;
        }

        int max = 0;
        char result = ' ';
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] > max) {
                max = alphabets[i];
                result = (char) (i + 65);
            }else if(alphabets[i] == max){
                result = '?';
//                break;
            }
        }
        System.out.println(result);
        br.close();
    }
}