package leetcode;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        int strLen = Integer.MIN_VALUE;
        String answer = "";

        int[][] arr = new int[s.length()][s.length()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {

                String pal = s.substring(i, j);
                int palinLen = checkPalindrome(pal);
                if (palinLen != 0 && palinLen > strLen) {
                    strLen = palinLen;
                    answer = pal;
                }
            }
        }

        System.out.println(answer);


        return answer;
    }

    public int checkPalindrome(String str) {

        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return 0;
            }
        }

        return len;
    }
}
