package LineCodingTest;

import java.util.HashMap;
import java.util.Map;

public class LevelOne {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = true;
        }

        Map<String, String> map = new HashMap<String, String>();

        for (String str : flag_rules) {
            String[] arr = str.split(" ");
            map.put(arr[0], arr[1]);
        }

        for (int j = 0; j < commands.length; j++) {
            String str = commands[j];
            String[] arr = str.split(" ");
            String flag = "";
            for (int i = 0; i < arr.length; i++) {

                if (i == 0) {
                    if (!arr[i].equals(program)) {
                        answer[j] = false;
                        break;
                    }
                } else if (i % 2 == 1) {
                    if (!map.containsKey(arr[i])) {
                        answer[j] = false;
                        break;
                    } else {
                        flag = arr[i];
                    }
                } else if (i % 2 == 0) {

                    String args = map.get(flag);

                    if (args.equals("STRING")) {
                        try {
                            int check = Integer.parseInt(arr[i]);
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    } else if (args.equals("NUMBER")) {
                        try {
                            int check = Integer.parseInt(arr[i]);
                        } catch (NumberFormatException e) {
                            answer[j] = false;
                            break;
                        }

                    } else if (args.equals("NULL")) {
                        Object obj = null;
                        try {
                            obj = arr[i];
                            String a = obj.getClass().getName();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("ArrayIndexOutOfBoundsException");
                            continue;
                        } catch (NullPointerException e) {
                            System.out.println("NullPointerException");
                            continue;
                        }


                    }
                }
            }

        }


        return answer;
    }
}
