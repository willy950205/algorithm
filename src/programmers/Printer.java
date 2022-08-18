package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {

        int now = location;
        Queue<Integer> printer = new LinkedList<>();
        for (int paper:
                priorities) {
            printer.offer(paper);
        }

        int answer = 0;
        return answer;
    }
}
