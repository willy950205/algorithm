package baekjoon;

import java.util.Scanner;

// + - * /
public class Baekjoon14888 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] num;
    static int[] operator;
    static int N;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scn.nextInt();
        }

        operator = new int[4];

        for (int i = 0; i < 4; i++) {
            operator[i] = scn.nextInt();
        }

        search(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    static public void search(int number, int index) {
        if (index == N) {
            MAX = Integer.max(MAX, number);
            MIN = Integer.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        search(number + num[index], index + 1);
                        break;
                    case 1:
                        search(number - num[index], index + 1);
                        break;
                    case 2:
                        search(number * num[index], index + 1);
                        break;
                    case 3:
                        search(number / num[index], index + 1);
                        break;

                }
                operator[i]++;
            }

        }


    }
}
