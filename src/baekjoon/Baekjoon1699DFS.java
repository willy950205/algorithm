package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1699DFS {

    static int minVal = Integer.MAX_VALUE;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        target = Integer.parseInt(input);

        dfs(0, 0);

        System.out.println(minVal);

    }

    public static void dfs(double result, int cnt) {
        if (result > target) {
            return;
        } else if (result == target) {
            minVal = Integer.min(minVal, cnt);
            return;
        }

        for (int i = 1; i <= target; i++) {
            dfs(result + (i * i), cnt + 1);
        }

    }


}
