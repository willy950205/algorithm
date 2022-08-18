package swmaestro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    static List<String> answer;
    static String[] skills;

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        answer = new ArrayList<String>();

        String str = scn.nextLine();
        skills = str.split(" ");


        boolean[][] tree = new boolean[skills.length][skills.length];

        int N = scn.nextInt();

        for (int i = 0; i < N; i++) {
            String tr = scn.nextLine();

            String first = tr.split(" ")[0];
            String second = tr.split(" ")[1];

            int f = 0;
            int s = 0;

            for (int j = 0; j < skills.length; j++) {
                if (skills[j].equals(first)) {
                    f = j;
                } else if (skills[j].equals(second)) {
                    s = j;
                }
            }

            tree[f][s] = true;
        }

        for (int i = 0; i < tree.length; i++) {

        }


    }

    public static void dfs(boolean[][] tree, int target, int index) {


        for (int j = target; j < tree[0].length; j++) {
            if (tree[target][j]) {

                answer.add(index, skills[j] + " ");


            }
        }


    }


}
