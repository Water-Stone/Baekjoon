import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> names = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if(cmd.equals("enter")){
                names.add(name);
            }else if(cmd.equals("leave")){
                names.remove(name);
            }
        }

        List<String> answer = new ArrayList<>(names.size());
        answer.addAll(names);
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for(int i= answer.size()-1;i>=0;i--){
            sb.append(answer.get(i) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
