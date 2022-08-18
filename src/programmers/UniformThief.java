package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniformThief {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        Arrays.sort(reserve);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : lost) {
            map.put(i, 0);
        }

        int a = 0;

        for (int i = 0; i < reserve.length; i++) {

            if (map.containsKey(reserve[i])) {
                a++;
                map.remove(reserve[i]);
                continue;
            } else if (reserve[i] == 1) {
                if (map.containsKey(2)) {
                    a++;
                    map.remove(2);
                    continue;
                }

            } else {

                if (map.containsKey(reserve[i] - 1)) {
                    a++;
                    map.remove(reserve[i] - 1);
                    continue;
                }
                if (map.containsKey(reserve[i] + 1)) {
                    a++;
                    map.remove(reserve[i] + 1);
                    continue;
                }

            }

        }

        answer = answer - lost.length + a;

        System.out.println(answer);

        return answer;
    }
}
