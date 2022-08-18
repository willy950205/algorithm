package programmers;

import java.util.Arrays;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(win_nums);

        int numCnt = 0;
        int rmNum = 0;

        for (int i : lottos) {
            if (i == 0) {
                rmNum++;
            }
            int result = Arrays.binarySearch(win_nums, i);
            if (result >= 0) {
                numCnt++;
            }
        }

        answer[0] = find(numCnt + rmNum);
        answer[1] = find(numCnt);

        return answer;
    }

    int find(int num) {

        int result = 0;

        switch (num) {
            case 1:
                result = 6;
                break;
            case 2:
                result = 5;
                break;
            case 3:
                result = 4;
                break;
            case 4:
                result = 3;
                break;
            case 5:
                result = 2;
                break;
            case 6:
                result = 1;
                break;

            default:
                result = 6;
                break;
        }

        return result;
    }
}
