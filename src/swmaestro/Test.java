package swmaestro;


import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String args[]) {

        String answer = "";

        Scanner scn = new Scanner(System.in);

        String input[] = scn.nextLine().split("");
        String[] num = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        String[] sit = {"십", "백", "천", "만"};

        Stack<String> stack = new Stack<String>();
        int cnt = 0;
        for (int i = 1; i < input.length; i++) {
            cnt %= 4;
            stack.add(sit[cnt]);
            cnt++;
        }

        for (int i = 0; i < input.length; i++) {
            int index = Integer.parseInt(input[i]);
            if (index != 0) {
                answer += num[index];
                if (!stack.isEmpty()) {
                    answer += stack.pop();
                }
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

        }

        System.out.println(answer);


    }
}
