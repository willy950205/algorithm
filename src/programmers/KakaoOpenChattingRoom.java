package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoOpenChattingRoom {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,State> map = new HashMap<>();
        int answerLen =0;

        for (String str:
             record) {
            String [] arr = str.split(" ");

            if(!arr[0].equals("Change")){
                answerLen++;
            }

            if(arr.length == 3){
                State state = new State(arr[2], arr[0]);
                map.put(arr[1], state);
            }

        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String [] arr = record[i].split(" ");
            String result = "";
            switch (arr[0]){
                case "Enter":
                    result = map.get(arr[1]).name + "님이 들어왔습니다.";
                    list.add(result);
                    break;
                case "Leave":
                    result = map.get(arr[1]).name + "님이 나갔습니다.";
                    list.add(result);
                    break;
                case "Change":
                    break;
            }

        }

        answer = list.toArray(new String[answerLen]);

        return answer;
    }

    class State{
        String name;
        String state;
        State(String name, String state){
            this.name = name;
            this.state = state;
        }
    }
}
