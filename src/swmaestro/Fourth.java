package swmaestro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fourth {
    public static void main(String args[]) {
        int x;
        Scanner scn = new Scanner(System.in);

        String n = scn.nextLine();
        int N = Integer.parseInt(n);
        List<Integer> list[] = new ArrayList[N * N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        int time = Integer.MIN_VALUE;

        for (int i = 0; i < N * N; i++) {
            String input = scn.nextLine();
            String arr[] = input.split(" ");
            for (int j = 2; j < arr.length; j++) {
                time = Integer.max(time, Integer.parseInt(arr[j]));
                list[i].add(Integer.parseInt(arr[j]));

            }
        }

        int answer = 0;

        for (int i = 0; i <= time; i++) {

            int score = 0;

            for (int j = 0; j < list.length; j++) {


                if (list[j].contains(i + 1)) {
                    score = Integer.max(score, j + 1);
                }
            }

            answer += score;
        }


        System.out.println(answer);


    }
}