package programmers;

public class ProBalloon {
    public int solution(int[] a) {
        int answer = 0;

        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
            }
            leftMin[i] = minValue;
        }

        minValue = Integer.MAX_VALUE;

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < minValue) {
                minValue = a[i];
            }
            rightMin[i] = minValue;
        }

        for (int i = 0; i < a.length; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }

            answer++;
        }

        System.out.println(answer);

        return answer;
    }
}
