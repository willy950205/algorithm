package LineCodingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class First {
    public String solution(String[] table, String[] languages, int[] preference) {


        Map<String, Integer> map = new HashMap<String, Integer>();

        List<String> list[] = new ArrayList[5];

        for (int i = 0; i < table.length; i++) {
            list[i] = new ArrayList<String>();
            String[] arr = table[i].split(" ");
            for (String str : arr) {
                list[i].add(str);
            }
        }


        for (int i = 0; i < languages.length; i++) {
            map.put(languages[i], preference[i]);
        }

        int[][] score = new int[preference.length][5];


        for (int i = 0; i < preference.length; i++) {
            for (int j = 0; j < 5; j++) {
                score[i][j] = Math.abs(list[j].indexOf(languages[i]) - 6);
                if (score[i][j] == 7) {
                    score[i][j] = 0;
                }
            }
        }


        String answer = "";
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            int temp = 0;
            for (int j = 0; j < languages.length; j++) {
                temp += score[j][i] * preference[j];
            }
            if (temp > maxScore) {
                maxScore = temp;
                answer = list[i].get(0);
            } else if (temp == maxScore) {
                char ch1 = answer.charAt(0);
                char ch2 = list[i].get(0).charAt(0);

                if (ch1 > ch2) {
                    answer = list[i].get(0);
                } else if (ch1 < ch2) {
                    continue;
                }
            }
        }

        return answer;
    }
}
