package LineCodingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Third {
    public int[] solution(int[] enter, int[] leave) {


        List<String> list = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        int enterIndex = 0;
        int leaveIndex = 0;


        while (true) {
            if (enterIndex < enter.length) {
                map.put(enter[enterIndex] + "", map.getOrDefault(enter[enterIndex] + "", list.size() - 1) + 1);
                list.add(enter[enterIndex] + "");
            }


            for (; leaveIndex < leave.length; leaveIndex++) {
                if (list.contains(leave[leaveIndex] + "")) {
                    list.remove(leave[leaveIndex] + "");
                }
            }


            enterIndex++;

            if (enterIndex >= enter.length && leaveIndex >= leave.length) {
                break;
            }

        }


        int[] answer = new int[map.size()];
        for (String key : map.keySet()) {
            answer[Integer.parseInt(key) - 1] = map.get(key);

        }

        return answer;
    }
}
