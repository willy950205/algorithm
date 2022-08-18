package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Baekjoon2606 {

    public static void main(String[] args) throws IOException {

        // 접근방법 : BFS
        // 어려웠던 점: BFS를 Queue로 구현하는 법을 까먹어서 약간의 검색.

        Queue<Integer> que = new LinkedList<Integer>();
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());
        int[][] arr = new int[com + 1][com + 1];
        boolean visited[] = new boolean[com + 1];

        for (int i = 1; i <= link; i++) {
            String input = br.readLine();
            String[] input2 = input.split(" ");
            arr[Integer.parseInt(input2[0])][Integer.parseInt(input2[1])] = 1;
            arr[Integer.parseInt(input2[1])][Integer.parseInt(input2[0])] = 1;

        }


        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {

            int node = que.poll();
            for (int i = 1; i <= com; i++) {
                if (i != node && arr[node][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }

        }


        System.out.println(cnt);

    }

}
