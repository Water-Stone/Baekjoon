import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, Integer> cards = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            long num = Long.parseLong(br.readLine());
            cards.put(num, cards.getOrDefault(num, 0) + 1);
        }

        int[] max = new int[]{0};
        List<Long> mostHaveCards = new ArrayList<>();
        cards.forEach((cardNumber, cnt)->{
            if(cnt > max[0]){
                max[0] = cnt;
                mostHaveCards.clear();
                mostHaveCards.add(cardNumber);
            }else if(cnt == max[0]){
                mostHaveCards.add(cardNumber);
            }
        });
        Collections.sort(mostHaveCards);
        bw.write(mostHaveCards.get(0).toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
