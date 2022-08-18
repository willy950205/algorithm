package gabia;

import java.util.*;

public class Third3 {
    public static void main(String[] args) {

        int N = 3;
        int coffee_times[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};


        int[] answer = solution(N, coffee_times);


    }

    public static int[] solution(int N, int coffee_times[]) {

        if (N == 1) {
            int[] answer = new int[coffee_times.length];
            for (int i = 0; i < coffee_times.length; i++) {
                answer[i] = i + 1;
            }
            return answer;
        }

        List<Integer> answerList = new ArrayList<Integer>();
        List<Coffee> list = new ArrayList<Coffee>();

        Queue<Coffee> que = new LinkedList<Coffee>();
        Coffee[] machine = new Coffee[N];


        // 뽑아쓰기 쉽게 큐에 넣기
        for (int i = 1; i <= coffee_times.length; i++) {
            Coffee coffee = new Coffee(i, coffee_times[i - 1]);
            que.add(coffee);
        }

        for (int i = 0; i < machine.length; i++) {
            if (!que.isEmpty()) {
                machine[i] = que.poll();
            }
        }


        while (true) {
            boolean c = false;
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < machine.length; i++) {
                mini = Integer.min(mini, machine[i].time);
            }

            for (int i = 0; i < machine.length; i++) {
                machine[i].time -= mini;
                if (machine[i].time == 0) {
                    answerList.add(machine[i].number);
                    if (!que.isEmpty()) {
                        machine[i] = que.poll();
                    }
                }
            }

            if (que.isEmpty()) {
                for (int i = 0; i < machine.length; i++) {
                    if (machine[i].time != 0) {
                        list.add(machine[i]);
                    }
                }
                c = true;
            }
            if (c) {
                break;
            }

        }

        Collections.sort(list, new Comparator<Coffee>() {
            @Override
            public int compare(Coffee o1, Coffee o2) {
                if (o1.time < o2.time) {
                    return -1;
                } else if (o1.time > o2.time) {
                    return 1;
                }
                return 0;
            }
        });


        for (int i = 0; i < list.size(); i++) {
            answerList.add(list.get(i).number);
//			System.out.print(list.get(i).time);
        }


        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
//		
        System.out.println(answerList);

        return answer;
    }
}
