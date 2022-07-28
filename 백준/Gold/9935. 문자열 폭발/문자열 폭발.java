import java.io.*;
import java.util.*;
public class Main {
    // stack 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bombCode = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombCode.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bombCode.length(); j++) {
                    if (stack.get(stack.size() - bombCode.length() + j) != bombCode.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                
                if (isBomb) {
                    for (int j = 0; j < bombCode.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}