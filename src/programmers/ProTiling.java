package programmers;

public class ProTiling {
    public int solution(int n) {
        int answer = 0;
        int mod = 1000000007;

        if (n == 1) {
            return answer;
        }

        long dp[] = new long[n + 1];

        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            long temp = 0;

            for (int j = 2; j <= i - 4; j += 2) {
                temp += dp[j] * 2;
            }

            dp[i] = (dp[i - 2] * 3 + 2 + temp) % mod;

        }

        answer = (int) dp[n];


        return answer;
    }
}
