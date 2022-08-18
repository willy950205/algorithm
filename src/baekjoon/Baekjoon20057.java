package baekjoon;

import java.util.Scanner;

public class Baekjoon20057 {

    static int[][] links;
    // 좌 하 우 상
    static int[][] way = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

    static int[] curr;

    // left 상황
    static int[][] calLeft = {
            { 1, -1, 0 },
            { 1, 1, 0 },
            { 2, -2, -1 },
            { 2, 2, -1 },
            { 5, 0, -3 },
            { 7, -1, -1 },
            { 7, 1, -1 },
            { 10, -1, -2 },
            { 10, 1, -2 }
    };

    // right 상황
    static int[][] calRight = {
            { 1, -1, 0 },
            { 1, 1, 0 },
            { 2, -2, 1 },
            { 2, -2, 1 },
            { 5, 0, 3 },
            { 7, -1, 1 },
            { 7, 1, 1 },
            { 10, -1, 2 },
            { 10, 1, 2 }
    };

    // up 상황
    static int[][] calUp = {
            { 1, 0, -1 },
            { 1, 0, 1 },
            { 2, -1, -2 },
            { 2, -1, 2 },
            { 5, -3, 0 },
            { 7, -1, -1 },
            { 7, -1, 1 },
            { 10, -2, -1 },
            { 10, -2, 1 }
    };

    // douw 상황
    static int[][] calDown = {
            { 1, 0, -1 },
            { 1, 0, 1 },
            { 2, 1, -2 },
            { 2, 1, 2 },
            { 5, 3, 0 },
            { 7, 1, -1 },
            { 7, 1, 1 },
            { 10, 2, -1 },
            { 10, 2, 1 }
    };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int wayCnt = 0;

        links = new int[n][n];

        // 현재 위치
        curr = new int[2];
        curr[0] = n / 2;
        curr[1] = n / 2;

        // links 채우기
        for (int i = 0; i < n; i++) {
            String a = scn.nextLine();
            String[] aSplit = a.split(" ");
            for (int j = 0; j < aSplit.length; j++) {
                links[i][j] = Integer.parseInt(aSplit[j]);
            }
        }

        while (curr[0] != 0 || curr[1] != 0) {

            int now = wayCnt % 4;

            // switch (now) {
            // // 좌
            // case 0:

            // currChange(now);
            // break;

            // // 하
            // case 1:

            // currChange(now);
            // break;

            // // 우
            // case 2:

            // currChange(now);
            // break;

            // // 상
            // case 3:

            // currChange(now);
            // break;

            // default:
            // break;
            // }

            wayCnt++;
        }
    }

    public static void currChange(int point) {
        switch (point) {
            // 좌
            case 0:
                curr[1] = curr[1] - 1;
                break;

            // 하
            case 1:
                curr[0] = curr[0] + 1;
                break;

            // 우
            case 2:
                curr[1] = curr[1] + 1;
                break;

            // 상
            case 3:
                curr[0] = curr[0] - 1;
                break;

            default:
                break;
        }
    }

    public static void calWay(int now) {
        switch (now) {
            // 좌
            case 0:
                // 이동하는 쪽으로 넘어가는 모래의 양
                // 55%
                // 넘어가는 모래의 양

                cal(calLeft, links[curr[0] + way[now][0]][curr[1] + way[now][1]], now);

                break;

            // 하
            case 1:

                break;

            // 우
            case 2:

                break;

            // 상
            case 3:

                break;

            default:
                break;
        }
    }

    public static void cal(int[][] arr, int nowCurrSand, int direction) {
        // 옆으로 넘어가는 모레의 양 55%
        int passSand = (int) (nowCurrSand * 0.55);
        // 옆으로 넘어가는 모레의 양 55% 을 더할 것

        // 다른곳으로 가는 모레의 양 45%를 계산하는 반복문
        for (int[] is : arr) {
            // 이동하는 곳 좌표 만들기
            // x 좌표
            int x = curr[0] + is[1];
            if (x < 0 || x >= links[0].length) {
                continue;
            }
            // y 좌표
            int y = curr[1] + is[2];
            if (y < 0 || y >= links[0].length) {
                continue;
            }

            links[x][y] += (nowCurrSand * is[0]) / 100;
        }

    }
}
