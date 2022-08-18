package leetcode;

import java.util.Stack;


public class leetcode101 {

    static Stack<Integer> stack = new Stack<>();

    public boolean isSymmetric(TreeNode root) {

        boolean answer = false;

        bfs(root);

        if (stack.size() == 1 && stack.peek() == 1) {
            answer = true;
        }
        System.out.println(answer);
        return answer;
    }

    public static void bfs(TreeNode node) {

        if (stack.isEmpty()) {
            stack.add(node.val);
        } else if (stack.peek() == node.val) {
            stack.pop();
        } else if (stack.peek() != node.val) {
            stack.add(node.val);
        }

        if (node.left == null && node.right == null) {

        } else {
            bfs(node.left);
            bfs(node.right);
        }
    }
}
