package tMax;

import java.util.HashMap;
import java.util.Map;

public class First {
    public int solution(String[] ings, String[] menu, String[] sell){

        // 재료값 맵
        Map<String, Integer> ingMap = new HashMap<>();
        for (String ing:ings) {
            String [] ingArr = ing.split(" ");
            ingMap.put(ingArr[0], Integer.parseInt(ingArr[1]));
        }

        // 각 음식에 대한 수익금액을 계산한 map이 있으면 말짱꽝임
        Map<String, Integer> fb = new HashMap<>();

        for (String food : menu) {

            // menu split
            String [] result = food.split(" ");

            // 각 음식의 수익금
            int pluse = Integer.parseInt(result[2]);

            // 각 음식의 수익금
            for (int i = 0; i < result[1].length(); i++) {
                String m = result[1].charAt(i)+"";
                pluse-=ingMap.get(m);
            }
            fb.put(result[0], pluse);
        }

        for (String am:sell) {
            String [] result = am.split(" ");

        }


        return 0;
    }
}









