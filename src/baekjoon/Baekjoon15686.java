package baekjoon;

import java.util.Scanner;

public class Baekjoon15686 {


    static int N;
    static int notM;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        String input1 = scn.nextLine();
        N = Integer.parseInt(input1.split(" ")[0]);
        int M = Integer.parseInt(input1.split(" ")[1]);
        int totalC = 0;

        int[][] city = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input2 = scn.nextLine();
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(input2.split(" ")[j]);
                if (city[i][j] == 2) {
                    totalC++;
                }
            }
        }

        notM = totalC - M;

        search(city, 0);

        System.out.println(answer);
    }

    static public void search(int[][] city, int cnt) {

        if (cnt == notM) {

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (city[i][j] == 1) {
                        int dis = findShortDis(city, i, j);
                        result += dis;
                    }
                }
            }

            answer = Integer.min(answer, result);
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (city[i][j] == 2) {
                    city[i][j] = 0;
                    search(city, cnt + 1);
                    city[i][j] = 2;
                }

            }
        }

    }

    static public int findShortDis(int[][] city, int i, int j) {

        int result = Integer.MAX_VALUE;


        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {

                if (city[a][b] == 2) {
                    result = Integer.min(result, Math.abs(i - a) + Math.abs(b - j));
                }


            }
        }

        return result;
    }
}





