package programmers;

import java.io.*;


public class Gene {
    static int[][] result;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();

        result = new int[input.length()][input.length()];


        for (int start = input.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < input.length(); end++) {
                if ((input.charAt(start) == 'a' && input.charAt(end) == 't') || (input.charAt(start) == 'g' && input.charAt(end) == 'c')) {
                    result[start][end] = result[start + 1][end - 1] + 2;
                }

                int add = 0;

                for (int i = start; i <= end; i++) {
                    if ((start + add + 1) >= input.length()) {
                        break;
                    }
                    result[start][end] = Integer.max(result[start][end], result[start][i] + result[start + (++add)][end]);

                }

            }
        }

        bw.write(result[0][input.length() - 1]);
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dp(int start, int end) {

        int maxValue = 0;

        if (start >= end) {
            return 0;
        } else {
            for (int i = start + 1; i < end; i++) {
                maxValue = Integer.max(maxValue, dp(start, i) + dp(i, end));
            }
        }

        if ((input.charAt(start) == 'a' && input.charAt(end) == 't') || (input.charAt(start) == 'g' && input.charAt(end) == 'c')) {
            maxValue = Integer.max(maxValue, dp(start + 1, end - 1) + 2);
        }

        result[start][end] = maxValue;


        return maxValue;
    }

}
