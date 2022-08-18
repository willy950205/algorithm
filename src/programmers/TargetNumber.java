package programmers;

public class TargetNumber {

    int[] numbers;
    int result;

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;

        find(0, target);

        return result;
    }

    public void find(int index, int target) {
        if (index == numbers.length) {
            if (target == 0) {
                result++;
            }
            return;
        }

        find(index + 1, target + numbers[index]);
        find(index + 1, target - numbers[index]);

    }
}
