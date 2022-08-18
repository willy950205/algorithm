package programmers;

import java.util.Stack;

public class KakaoCrane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();
        int index = 0;
        int doll = 0;

        while (index < moves.length) {

            for (int i = 0; i < board.length; i++) {
                if (board[i][moves[index] - 1] != 0) {
                    doll = board[i][moves[index] - 1];
                    board[i][moves[index] - 1] = 0;
                    break;
                }
            }


            if (!bucket.isEmpty() && doll != 0) {
                if (bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            } else if (bucket.isEmpty() && doll != 0) {
                bucket.push(doll);
            }

            doll = 0;
            index++;
        }


        return answer;
    }
}
