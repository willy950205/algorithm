package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// 접근방법 : dfs 사용.
// 어려웠던 점 : 처음엔 인접리스트를 사용해 접근하려 했으나 실패. 리스트 탐색과 동시에 알파벳 순서를 생각했기 때문.
// 그래서 {{"ICN", "A"}, {"ICN","B"},{"B","ICN"}} 과 같은 리스트를 해결 할 수 없엇음.
// 결국 인터넷 검색 후 boolean visited[]을 사용하는 방법 깨달음 -> 티켓 사용 여부 판단.
// dfs 메소드 구현 후 재귀 호출. 재귀의 depth가 티켓수와 같아 진 모든 경우를 찾고 마지막에 알파벳 순으로 잘 들어간
// 루트를 탐색.

public class TravelRoute {
    List<String> list = new ArrayList<String>();
    String route = "";
    boolean visited[];

    public void dfs(String[][] tickets, String destination, int cnt) {

        route += destination + ",";

        if (cnt == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];

            if (start.equals(destination) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, end, cnt + 1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }

    public String[] solution(String[][] tickets) {

        String[] answer = {};
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];

            if (start.equals("ICN") && !visited[i]) {
                visited[i] = true;
                route = start + ",";
                dfs(tickets, end, 1);
                visited[i] = false;
            }
        }

        Collections.sort(list);
        answer = list.get(0).split(",");

        String ss = "safdasdf";
        //ss.sp


        return answer;
    }
}
