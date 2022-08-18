package programmers;

public class TargetN {

    static int end;
    static int answer;
    static int[] arr;

    public int solution(int[] numbers, int target) {
        answer = 0;
        end = numbers.length;
        arr = numbers;

        dfs(target, 1, arr[0]);
        dfs(target, 1, -arr[0]);

        System.out.println("answer : " + answer);

        return answer;
    }

    public void dfs(int target, int index, int result) {

        if (index == arr.length) {
            if (result == target) {
                System.out.println("result : " + result);
                answer++;
            }
            return;
        }

        dfs(target, index + 1, result + arr[index]);
        dfs(target, index + 1, result - arr[index]);

    }
}
