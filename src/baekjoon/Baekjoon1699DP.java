package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1699DP {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        int dp[][] = new int[N + 1][N + 1];


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if ((i * i) > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if ((i * i) == j) {
                    dp[i][j] = 1;
                } else if ((i * i) < j) {
                    int result = 0;
                    int temp = 0;
                    if (j % (i * i) == 0) {
                        dp[i][j] = j / (i * i);
                    } else {
                        result = j / (i * i);
                        temp = j % (i * i);
                        dp[i][j] = result + dp[i - 1][temp];
                    }

                }

            }
            answer = Integer.min(answer, dp[i][N]);
        }

//		for(int i=1; i<dp.length; i++) {
//			for(int j=1; j<dp.length; j++) {
//				System.out.print(dp[i][j]+" ");
//				
//			}
//			System.out.println();
//		}

        System.out.println(answer);

    }

}
