package programmers;

public class ProCenterString {
    public String solution(String s) {
        String answer = "";


        int len = s.length();


        if (len % 2 == 1) {
            answer = s.charAt(len / 2) + "";
        } else {
            answer = s.substring(len / 2 - 1, len / 2 + 1);
        }

        return answer;
    }
}