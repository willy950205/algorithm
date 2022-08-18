package kakao;

import java.util.*;
import java.util.stream.Collectors;

public class KakaoFindBadUser {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, List<String>> reportByMan = new HashMap<>();
        Map<String, Integer> removeDup = new HashMap<>();
        for (String a: report) {
            removeDup.put(a,0);
        }

        // 각 아이디별 신고당한 횟수
        for (String detail: removeDup.keySet()) {
            String [] detailList = detail.split(" ");
            reportCnt.put(detailList[1], reportCnt.getOrDefault(detailList[1], 0)+1);

            if(!reportByMan.containsKey(detailList[0])){
                List<String> reportList = new ArrayList<>();
                reportList.add(detailList[1]);
                reportByMan.put(detailList[0], reportList);
            }else{
                List<String> reportList = reportByMan.get(detailList[0]);
                reportList.add(detailList[1]);
                reportByMan.put(detailList[0], reportList);
            }
        }

        List<String> stopId = new ArrayList<>();

        for (String key:reportCnt.keySet()) {
            if(reportCnt.get(key) >= k ){
                stopId.add(key);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            String key = id_list[i];
            // key user가 신고한 사람들 리스트
            List<String> list = reportByMan.get(key);
            String user = id_list[i];
            if(list != null){
                for (int j = 0; j < list.size(); j++) {
                    if(stopId.contains(list.get(j))){
                        answer[i]++;
                    }
                }
            }

        }


        return answer;
    }

    public int[] solution2(String[] id_list, String[] report, int k){
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();

    }
}