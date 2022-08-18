package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1699DP2 {
    public static void main(String args[]) throws IOException {

        // 어려웠던 점 : 점화식을 찾는 과정이 매우 오래걸림. 규칙을 찾는거 이외에 구현은 어렵지 않음
        // 문제 접근 : 1부터 N까지, 답을 찾아가며 앞의 답을 이용한다.
        // N의 값을 구하기 위해서는 우선 가장 큰 원소를 어떤 것으로 할지를 정해야 한다.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            int answer = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int result = i / (j * j);
                int temp = i % (j * j);
                answer = Integer.min(answer, result + dp[temp]);
            }
            dp[i] = answer;
        }

        System.out.println(dp[N]);

    }
}
