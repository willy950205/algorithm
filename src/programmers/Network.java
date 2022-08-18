package programmers;

public class Network {

    // dfs로 구현
    // dfs를 재귀를 사용하여 구현하였다. 값이 커지면
    // 연산이 매우 오래걸리는 단점이 있을 수 있겠다.
    // 다음부터 간단한 dfs는 스택을 사용하여 구현하도록 노력해야겠다.

    // 방문 여부를 체크하는 boolean 배열.
    // dfs를 재귀 형태로 구현하였기 때문에 전역 변수로 선언하였다.
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 배열 생성
        visited = new boolean[n];

        // 모든 노드를 방문하기 위한 반복문
        for (int node = 0; node < n; node++) {

            //만약 방문하지 않았다면 방문하는 조건문
            if (!visited[node]) {
                // 동시에 네트워크 개수를 하나 증가시킨다
                answer++;
                // 연결된 컴퓨터를 찾기위한 dfs
                dfs(n, node, computers, visited);
            }

        }

        return answer;
    }

    // dfs구현부
    public void dfs(int n, int node, int[][] computers, boolean[] visited) {
        // 방문한 노드에 방문 여부를 true로 체크해준다.
        visited[node] = true;

        // 연결된 노드에 방문하기 위한 반복문
        for (int i = 0; i < n; i++) {
            // 만약
            // computers[node][i]==1 : 연결되어있고
            // i!=node : 해당 노드가 자기 자신이 아니며
            // !visited[i] : 방문한 적이 없다면
            // dfs를 실시한다.
            if (computers[node][i] == 1 && i != node && !visited[i]) {
                dfs(n, i, computers, visited);
            }
        }
    }
}
