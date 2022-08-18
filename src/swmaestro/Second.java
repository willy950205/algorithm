package swmaestro;

import java.util.*;

public class Second {
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);
        String fInput = scn.nextLine();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> answerMap = new HashMap<Integer, Integer>();


        String p = fInput.split(" ")[0];
        String n = fInput.split(" ")[1];
        String h = fInput.split(" ")[2];

        for (int i = 1; i <= Integer.parseInt(p); i++) {
            map.put(i, Integer.parseInt(h));
            answerMap.put(i, 0);
        }


        for (int i = 1; i <= Integer.parseInt(n); i++) {

            String str = scn.nextLine();
            int num = Integer.parseInt(str.split(" ")[0]);
            int hour = Integer.parseInt(str.split(" ")[1]);

            if (map.get(num) >= hour) {
                int last = map.get(num) - hour;
                map.put(num, last);

                answerMap.put(num, answerMap.get(num) + 1000 * hour);
            }

        }


        List<Integer> answer = new ArrayList<Integer>();
        answer.add(0, 0);
        for (int i = 1; i <= Integer.parseInt(p); i++) {
            answer.add(i, answerMap.get(i));
        }

        for (int i = 1; i <= Integer.parseInt(p); i++) {
            System.out.println(i + " " + answer.get(i));
        }


    }
}
