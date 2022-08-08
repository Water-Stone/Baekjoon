import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfHouses = Integer.parseInt(st.nextToken());
        int numOfWifiRouter = Integer.parseInt(st.nextToken());

        List<Integer> houses = new ArrayList<>(numOfHouses);
        for (int i = 0; i < numOfHouses; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(houses);

        int low = 1;    // 최소 1칸
        int high = houses.get(numOfHouses - 1) - houses.get(0) + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            int cnt = 1;
            int lastHouse = houses.get(0);

            for (int i = 1; i < numOfHouses; i++) {
                int currHouse = houses.get(i);

                if (currHouse - lastHouse >= mid) {
                    cnt++;
                    lastHouse = currHouse;
                }
            }

            if (cnt < numOfWifiRouter) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }
}
