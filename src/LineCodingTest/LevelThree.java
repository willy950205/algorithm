package LineCodingTest;

import java.util.HashMap;
import java.util.Map;

public class LevelThree {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = true;
        }

        Map<String, String> map = new HashMap<String, String>();

        for (String str : flag_rules) {
            String[] arr = str.split(" ");
            if (arr.length == 3) {
                map.put(arr[0], map.get(arr[2]));
            } else {
                map.put(arr[0], arr[1]);
            }

        }

        for (int j = 0; j < commands.length; j++) {
            String str = commands[j];
            String[] arr = str.split(" ");
            String flag = "";
            int strCheck = 0;
            int numberCheck = 0;
            for (int i = 0; i < arr.length; i++) {

                if (i == 0) {
                    if (!arr[i].equals(program)) {
                        answer[j] = false;
                        break;
                    }
                } else if (arr[i].charAt(0) == '-') {
                    strCheck = 0;
                    numberCheck = 0;
                    if (!map.containsKey(arr[i])) {
                        answer[j] = false;
                        break;
                    } else {
                        flag = arr[i];
                    }
                } else {

                    String args = map.get(flag);

                    if (args.equals("STRING")) {
                        strCheck++;
                        if (strCheck > 1) {
                            answer[j] = false;
                            break;
                        }
                        try {
                            int check = Integer.parseInt(arr[i]);
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    } else if (args.equals("NUMBER")) {
                        numberCheck++;
                        if (numberCheck > 1) {
                            answer[j] = false;
                            break;
                        }
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
                            continue;
                        } catch (NullPointerException e) {
                            continue;
                        }
                    } else if (args.equals("NUMBERS")) {
                        while (true) {
                            Object obj = null;
                            try {
                                obj = arr[i];
                                String a = obj.getClass().getName();
                                int check = Integer.parseInt(arr[i]);
                            } catch (ArrayIndexOutOfBoundsException e) {

                                continue;
                            } catch (NullPointerException e) {

                                continue;
                            } catch (NumberFormatException e) {
                                answer[j] = false;
                                break;
                            }

                            try {
                                if (arr[i + 1].charAt(0) == '-') {
                                    break;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            } catch (NullPointerException e) {
                                break;
                            }
                            i++;

                        }
                    } else if (args.equals("STRINGS")) {

                        while (true) {
                            try {
                                int check = Integer.parseInt(arr[i]);
                            } catch (NumberFormatException e) {

                            }
                            try {
                                if (arr[i + 1].charAt(0) == '-') {
                                    break;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                break;
                            } catch (NullPointerException e) {
                                break;
                            }
                            i++;


                        }


                    }
                }
            }

        }

        for (boolean a : answer) {
            System.out.println(a);
        }


        return answer;
    }
}
