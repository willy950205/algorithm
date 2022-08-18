package programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 해시 문제. 완주하지 못한 선수

public class ProUnfinishedMan {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참가한 선수들을 이름별로 카운트 하기 위한 해시맵을 만들었다.
        Map<String, Integer> map = new HashMap<>();

        // 참가한 선수들의 이름을 key값으로, 그리고 해당 이름의 참가자가 몇 명인지 카운트 할 수있는
        // getOrDefault 메소드를 사용한다. 해당 이름이 map 내부에 없다면 key에 이름을 추가 후
        // value 값으로 1을 넣어준다. map 내부에 존재 한다면 1을 더해준다. 그렇게 하면 각 이름 당 몇 명의 참가자가 있는지 알 수 있는
        // map이 완성된다.
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);

        }


        // 위의 for문과 달리 완주자 배열을 돌며 map에서 1씩 빼준다.
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
        }

        // map의 value를 확인하여 1인 값의 key 즉, 미완주자의 이름을 return한다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return answer;
    }
}
