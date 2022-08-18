package programmers;

public class ExpresswithN {

    int answer = Integer.MAX_VALUE;
    int N;
    int number;

    public int solution(int N, int number) {

        this.N = N;
        this.number = number;

        search(0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        return answer;
    }

    public void search(int count, int result) {
        if (count > 8) {
            this.answer = -1;
            return;
        }

        if (result == this.number) {
            this.answer = Integer.min(answer, count);
            return;
        }

        int temp = this.N;
        for (int i = 0; i < 8 - count; i++) {
            int tempCount = count + 1 + i;

            search(tempCount, result + temp);
            search(tempCount, result - temp);
            search(tempCount, result * temp);
            search(tempCount, result / temp);

            temp = temp * 10 + this.N;

        }


    }
}
