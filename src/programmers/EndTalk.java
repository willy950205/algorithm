package programmers;

import java.util.HashMap;
import java.util.Map;

public class EndTalk {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();

        // 틀린 곳
        int target = -1;

        for (int i = 0; i < words.length; i++) {

            if (i != 0 && !words[i - 1].endsWith(String.valueOf(words[i].charAt(0)))) {
                target = i;
                break;
            }

            if (!map.containsKey(words[i])) {
                map.put(words[i], 0);
            } else {
                target = i;
                break;
            }
        }

        if (target == -1) {
            return answer;
        } else {
            answer[0] = (target % n) + 1;

            int a = target - (target % n);
            int b = (a / n) + 1;

            answer[1] = b;

        }

        return answer;
    }

}
