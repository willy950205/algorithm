package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon11478 {

    static String input;
    static Map<String, Integer> answerMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        answerMap = new HashMap<String, Integer>();

        for (int i = 1; i <= input.length(); i++) {
            find(i);
        }


        System.out.println(answerMap.size());

    }

    public static void find(int len) {


        for (int i = 0; i < input.length(); i++) {


            if (input.length() >= len + i) {
                Map<Character, Integer> map = new HashMap<Character, Integer>();
                boolean check = true;
                String temp = input.substring(i, len + i);
                for (int j = 0; j < temp.length(); j++) {
                    char ch = temp.charAt(j);
                    if (!map.containsKey(ch)) {
                        map.put(ch, 0);
                    } else {
                        check = false;
                        break;
                    }
                }


                if (check) {
//					System.out.println(temp);
                    answerMap.put(temp, answerMap.getOrDefault(temp, 0) + 1);
                }
            }

        }

    }

}
