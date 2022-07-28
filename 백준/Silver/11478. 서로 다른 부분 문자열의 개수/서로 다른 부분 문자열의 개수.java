import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        br.close();

        Set<String> set = new HashSet<>();

        for(int i=1; i<=sb.length();i++){
            for(int j=0;j < sb.length() + 1 - i; j++){
                set.add(sb.substring(j,j+i));
            }
        }

        System.out.println(set.size());
    }
}
