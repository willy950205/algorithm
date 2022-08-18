package programmers;

public class Biggest {
    public int solution(int[][] board) {
        int answer = 0;

        int[][] dp = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (dp[i][j] == 1) {
                    int input = Integer.min(dp[i - 1][j - 1], dp[i][j - 1]);
                    input = Integer.min(input, dp[i - 1][j]);
                    dp[i][j] = input + 1;
                    answer = Integer.max(dp[i][j], answer);
                }
            }
        }

        System.out.println(answer * answer);

        return answer;
    }
}
