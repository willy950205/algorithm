package LineCodingTest;

import java.util.*;

public class Second {
    public int[] solution(String inp_str) {

        List<Integer> answerList = new ArrayList<Integer>();
        String spcial = "~!@#$%^&*";

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Integer, Integer> threeMap = new HashMap<Integer, Integer>();

        if (inp_str.length() < 8 || inp_str.length() > 15) {
            answerList.add(1);
        }

        char before = '=';
        int duplCnt = 1;

        for (int i = 0; i < inp_str.length(); i++) {

            char ch = inp_str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (before == ch) {
                duplCnt++;
            }

            if (duplCnt >= 4) {
                if (!answerList.contains(4))
                    answerList.add(4);

            }


            int check = 0;

            if (ch >= 48 && ch <= 57) {
                threeMap.put(1, threeMap.getOrDefault(1, 0) + 1);
                check++;
            }
            if (ch >= 65 && ch <= 90) {
                threeMap.put(2, threeMap.getOrDefault(2, 0) + 1);
                check++;
            }
            if (ch >= 97 && ch <= 122) {
                threeMap.put(3, threeMap.getOrDefault(3, 0) + 1);
                check++;
            }
            if (spcial.contains(ch + "")) {
                threeMap.put(4, threeMap.getOrDefault(4, 0) + 1);
                check++;
            }

            if (check == 0) {
                if (!answerList.contains(2))
                    answerList.add(2);
            }

            before = ch;

        }


        if (threeMap.size() < 3) {
            if (!answerList.contains(3))
                answerList.add(3);

        }

        for (char ch : map.keySet()) {
            if (map.get(ch) >= 5) {
                if (!answerList.contains(5))
                    answerList.add(5);
            }
        }

        Collections.sort(answerList);

        if (answerList.size() == 0) {
            int[] answer = new int[1];
            answer[0] = 0;
            return answer;
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
