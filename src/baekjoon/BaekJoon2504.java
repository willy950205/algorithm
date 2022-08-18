package baekjoon;

import java.util.Scanner;
import java.util.Stack;


public class BaekJoon2504 {
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();


        char[] arr = str.toCharArray();

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(' || arr[i] == '[') {
                stack.add(Character.toString(arr[i]));
            } else if (arr[i] == ')') {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.add("2");
                } else if (!stack.peek().equals("(")) {
                    int a = Integer.parseInt(stack.pop()) * 2;
                    stack.pop();

                    if (stack.isEmpty()) {
                        stack.add(a + "");
                        continue;
                    }

                    if (!stack.peek().equals("(") && !stack.peek().equals("[")) {
                        int b = Integer.parseInt(stack.pop());
                        stack.add(a + b + "");
                    } else {
                        stack.add(a + "");
                    }

                }
            } else if (arr[i] == ']') {
                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.add("3");
                } else if (!stack.peek().equals("[")) {
                    int a = Integer.parseInt(stack.pop()) * 3;
                    stack.pop();

                    if (stack.isEmpty()) {
                        stack.add(a + "");
                        continue;
                    }

                    if (!stack.peek().equals("(") && !stack.peek().equals("[")) {
                        int b = Integer.parseInt(stack.pop());
                        stack.add(a + b + "");
                    } else {
                        stack.add(a + "");
                    }
                }
            }


        }

        String answer = "";

        if (!stack.isEmpty()) {
            answer = stack.pop();
            switch (answer) {
                case "(":
                    System.out.println("0");
                    break;
                case "[":
                    System.out.println("0");
                    break;
                case ")":
                    System.out.println("0");
                    break;
                case "]":
                    System.out.println("0");
                    break;

                default:
                    System.out.println(answer);
                    break;
            }

        } else if (stack.isEmpty()) {
            System.out.println("0");
        }

    }
}
