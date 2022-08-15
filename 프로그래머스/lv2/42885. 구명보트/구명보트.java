import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>(people.length);
        for (int i : people) list.add(i);

        Collections.sort(list);

        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (list.get(left) + list.get(right) <= limit)
                left++;
            answer++;
            right--;
        }

        return answer;
    }
}