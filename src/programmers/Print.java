package programmers;

import java.util.*;
public class Print {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        Queue<Node> tempQ = new LinkedList<>();

        for(int i = 0; i< priorities.length; i++ ){
            Node node = null;
            if(i==location){
                node = new Node(priorities[i], true);
            }else{
                node = new Node(priorities[i], false);
            }
            q.offer(node);
        }

        while(!q.isEmpty()){

            Node first = q.poll();
            int num = first.pri;
            Node second = null;
            while(!q.isEmpty()){
                second = q.poll();
                tempQ.offer(second);
                num = Math.max(num, second.pri);
            }

            while(!tempQ.isEmpty()){
                Node node = tempQ.poll();
                q.offer(node);
            }

            if(num == first.pri){
                answer++;
                if(first.check) return answer;
            }else{
                q.offer(first);
            }
        }

        return answer;
    }

    class Node{
        int pri;
        boolean check;

        public Node(int pri, boolean check){
            this.pri = pri;
            this.check = check;
        }
    }
}
