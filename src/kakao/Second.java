package kakao;

import java.util.ArrayList;
import java.util.List;

public class Second {

    int answer = Integer.MIN_VALUE;
    int[][] needs;
    int r;
    List<Integer> list[];

    public int solution(int[][] needs, int r) {

        this.needs = needs;
        this.r = r;

        // 각 완제품에 필요한 부품들
        list = new ArrayList[needs.length];

        // 구매한 로봇들
        List<Integer> robots = new ArrayList<Integer>();

        // 각 번호의 완제품을 만드는데 필요한 부품번호를 리스트에 저장
        for (int i = 0; i < needs.length; i++) {
            list[i] = new ArrayList<Integer>();
            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }

//        for(List<Integer> a:list) {
//        	for(int s : a) {
//        		System.out.print(s+" ");
//        	}
//        	System.out.println();
//        }


        search(robots, 0);

        System.out.println("answer : " + answer);
        return answer;
    }


    public void search(List<Integer> robots, int index) {
        if (robots.size() == r) {
            System.out.println(robots);
            int cnt = 0;

            for (int i = 0; i < list.length; i++) {
                boolean check = true;
                for (int parts : list[i]) {

                    if (!robots.contains(parts)) {
                        System.out.println("check");
                        check = false;
                    }

                }
                if (check) {
                    cnt++;
                }

            }
            System.out.println("cnt " + cnt);
            answer = Integer.max(answer, cnt);

            return;
        } else {
            for (int i = index; i < needs[1].length; i++) {

                robots.add(i);
                search(robots, i + 1);
                if (i < needs.length - r) {
                    int index1 = robots.indexOf(i);
                    robots.remove(index1);
                    search(robots, i + 1);
                }

            }
        }


    }
}
