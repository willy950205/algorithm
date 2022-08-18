package programmers;

public class CalculateShortfall {
    public long solution(int price, int money, int count) {
        long np = 0;
        long answer = -1;
        int cnt = 1;

        while (count >= cnt){
            np+=(price*cnt);
            cnt++;
        }

        answer = np - money;
        if(answer<0){
            answer=0;
        }

        System.out.println(answer);

        return answer;
    }
}
