package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestWay2 {

    int [][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public int solution(int[][] maps) {

        boolean [][] check = new boolean[maps.length][maps[0].length];

        int answer = bfs(maps,check);

        return answer;
    }

    int bfs(int[][] maps, boolean [][] check){

        Queue<Node> queue = new LinkedList<>();

        Node start = new Node(0,0, 1);
        queue.add(start);
        check[start.x][start.y] = true;

        int answer = -1;

        while(!queue.isEmpty()){

            Node now = queue.poll();
            if(now.x== maps.length-1 && now.y == maps[0].length-1){
                answer = now.length;
            }

            for (int[] dir : direction) {

                Node next = new Node(now.x+dir[0], now.y+dir[1], now.length+1);

                if(next.x<0 || next.x>= maps.length || next.y < 0 || next.y >= maps[0].length || maps[next.x][next.y] == 0){
                    continue;
                }else{
                    if(!check[next.x][next.y]){
                        check[next.x][next.y] = true;
                        queue.offer(next);
                    }
                }
            }



        }
        return answer;

    }
}

class Node{
    int x;
    int y;
    int length;
    public Node(int x, int y, int length){
        this.x = x;
        this.y = y;
        this.length = length;
    }
}
