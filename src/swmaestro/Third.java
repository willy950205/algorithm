package swmaestro;

import java.util.Scanner;

public class Third {
    public static void main(String args[]) {

        int MAX = Integer.MIN_VALUE;

        Scanner scn = new Scanner(System.in);

        String n = scn.nextLine();
        int N = Integer.parseInt(n);

        String input = scn.nextLine();
        String[] inputArr = input.split(" ");
        int[] arr = new int[N];
        boolean visited[] = new boolean[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            int now = i;
            while (true) {
                if (visited[now]) {
                    MAX = Integer.max(MAX, cnt);
                    break;
                }

                int way = arr[now];
                visited[now] = true;
                now = now + way;
                cnt++;
            }


        }

        System.out.println(MAX + 1);


    }
}