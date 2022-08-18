package gabia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Third2 {
    public static void main(String[] args) {

//		int N = 3;
//		int coffee_times [] = {100,1,50,1,1,20};

        int N = 100;
        int coffee_times[] = {90, 1, 1, 100000000, 100000000, 100000000, 100000000, 100000001, 1};

        int[] answer = solution(N, coffee_times);


    }

    public static int[] solution(int N, int coffee_times[]) {

        List<Integer> list = new ArrayList<Integer>();

        Queue<Coffee> que = new LinkedList<Coffee>();
        Queue<Coffee> mQue = new LinkedList<Coffee>();

        // 뽑아쓰기 쉽게 큐에 넣기
        for (int i = 1; i <= coffee_times.length; i++) {
            Coffee coffee = new Coffee(i, coffee_times[i - 1]);
            que.add(coffee);
        }

        for (int i = 0; i < N; i++) {
            if (!que.isEmpty()) {
                mQue.add(que.poll());
            } else {
                break;
            }
        }


        while (!mQue.isEmpty()) {

            if (!mQue.isEmpty() && mQue.peek().time > 1) {
                Coffee temp = new Coffee(mQue.peek().number, mQue.peek().time - 1);
                mQue.poll();
                mQue.add(temp);
            } else if (!mQue.isEmpty() && mQue.peek().time == 1) {
                Coffee temp = mQue.poll();
                list.add(temp.number);
                if (!que.isEmpty()) {
                    mQue.add(que.poll());
                }
            }

        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        System.out.println(list);

        return answer;
    }
}
