package programmers;

import java.util.HashMap;
import java.util.Map;

public class Phonekemon {


    public int solution(int[] nums) {
        int answer = 0;

        int N = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.size() <= N) {
            answer = map.size();
        } else if (map.size() > N) {
            answer = N;
        }

        return answer;
    }

}
