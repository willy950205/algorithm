package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1753 {

    // 인접 리스트 선언
    static List<Edge> list[];
    // 각 노드까지의 최단거리 기록 정수 배열 선언
    static int dis[];
    // 각 노드 최종 값 확인 boolean 배열 선언
    static boolean check[];

    // Edge 내부클래스를 만든다.
    static class Edge implements Comparable<Edge> {
        int end, weight;

        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        // 우선순위 큐를 이용하기 위해서 가중치를 비교하도록
        // compareTo 메소드를 override 한다.
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.weight - o.weight;
        }

    }

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        // 다익스트라 알고리즘 사용
        // 어려웠던 점 : 다익스트라를 실제로 구현하는 부분이 가장 어려웠음.
        // 수도 코드만으로는 힘들어서 결국 자료를 찾아봄

        int V = scn.nextInt();
        int E = scn.nextInt();
        int startNode = scn.nextInt() - 1;

        // 거리를 초기화 할 최장거리 선언
        int initNum = Integer.MAX_VALUE;

        // 생성
        list = new ArrayList[V];
        dis = new int[V];
        check = new boolean[V];

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < E; i++) {
            int a = scn.nextInt() - 1;
            int b = scn.nextInt() - 1;
            int c = scn.nextInt();

            list[a].add(new Edge(b, c));
        }

        // 초기값으로 모든 최소가중치들을 설정해준다.
        for (int i = 0; i < V; i++) {
            dis[i] = initNum;
        }

        // 다익스트라 메소드 실행
        dijkstra(startNode);

        // 출력부
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == initNum) {
                System.out.println("INF");
            } else {
                System.out.println(dis[i]);
            }

        }

    }

    // 다익스트라 알고리즘 구현부
    public static void dijkstra(int startNode) {
        // 우선순위 큐를 통해 가중치가 가장 작은 Edge 부터 poll되게 한다.
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 시작점을 pq에 넣어준다.
        pq.add(new Edge(startNode, 0));
        // 시작점, 자기 자신까지의 최소가중치는 0으로 설정해준다.
        dis[startNode] = 0;

        while (!pq.isEmpty()) {
            // 연결되어있는 노드들을 하나씩 꺼낸다.
            Edge edge = pq.poll();
            // 만약 해당 노드까지 확정된 최소 가중치가 있다면 넘어간다.
            if (check[edge.end]) {
                continue;
            }

            // 최소가중치를 찾는 반복문이다.
            // list[edge.end] 는 Edge들을 갖고있는 ArrayList이다.
            // 즉 연결되어있는 Edge들을 하나씩 꺼내는 반복문이다.
            for (Edge nextNode : list[edge.end]) {
                // 현재 기록되어있는 다음 노드까지의 최소가중치가
                // 지금 노드까지의 최소 가중치 + 지금 노드에서 다음노드까지 기록되어있는 가중치
                // 보다 크면 교체
                if (dis[nextNode.end] > dis[edge.end] + nextNode.weight) {
                    dis[nextNode.end] = dis[edge.end] + nextNode.weight;
                    pq.add(new Edge(nextNode.end, dis[nextNode.end]));
                }
            }

            // 최소가중치를 찾았다고 표시한다.
            check[edge.end] = true;

        }

    }
}
