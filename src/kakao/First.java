package kakao;

import java.util.ArrayList;
import java.util.List;

public class First {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;

        boolean[] check = new boolean[wants.length];
        List<Integer> list = new ArrayList<Integer>();
        int cnt1 = 0;
        int cnt2 = 0;

        // 원하는거면 true
        for (int i = 0; i < gift_cards.length; i++) {
            if (gift_cards[i] == wants[i]) {
                check[i] = true;
            } else {
                list.add(gift_cards[i]);
                cnt1++;
            }
        }

        for (int i = 0; i < gift_cards.length; i++) {
            if (!check[i] && list.contains(wants[i])) {
                gift_cards[i] = wants[i];
                int index = list.indexOf(wants[i]);
                list.remove(index);
                cnt2++;
            }
        }

        answer = cnt1 - cnt2;

        return answer;
    }
}
