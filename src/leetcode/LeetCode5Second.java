package leetcode;

public class LeetCode5Second {
    public String longestPalindrome(String s) {
        int strLen = Integer.MIN_VALUE;
        String answer = "";

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j >= i; j--) {
                boolean check = true;
                String str = s.substring(i, j);
                int result = checkPalindrome(arr, i, j);

                if (result != 0 && strLen < result) {
                    strLen = result;
                    answer = str;
                }

            }

        }

        System.out.println(answer);

        return answer;
    }

    public int checkPalindrome(char[] arr, int k, int j) {

        int len = j - k;

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return 0;
            }
        }

        return len;
    }

}
