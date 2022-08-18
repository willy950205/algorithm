package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LightCycle {

    int pastX;
    int pastY;
    String pasthere;
    int sx;
    int sy;
    String[] grid;
    int wayCnt;

    public int[] solution(String[] grid) {

        this.grid = grid;

        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < grid[0].length(); i++) {
            wayCnt = 0;
            this.sx = 0;
            this.sy = i;
            // this.pastX = this.sx;
            // this.pastY = this.sy;
            find(0, i);
            list.add(wayCnt);
        }

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                continue;
            }
            wayCnt = 0;
            // this.pastX = i;
            // this.pastY = 0;
            // this.sx = i;
            this.sy = 0;

            find(i, 0);
            list.add(wayCnt);
        }

        list.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());

        return answer;
    }

    public void find(int x, int y) {

        wayCnt++;
        String here = grid[x].charAt(y) + "";

        if (x == sx && y == sy) {
            return;
        }

    }

    public int nextXSight(int x, String here) {

        // 이전거가 s라면

        switch (here) {
            case "S":

                break;
            case "L":

                break;
            case "R":

                break;

            default:
                break;
        }

        if (x + 1 > grid.length - 1) {
            return 0;
        }

        return 0;

    }

    public boolean nextYSight(int y) {

        if (y + 1 > grid[0].length() - 1) {
            return false;
        }

        return true;

    }

    public void next(String here) {

        String from = "";

        if (this.sx != this.pastX) {
            if (this.sx > this.pastX) {
                // 내 기준 위에서 들어옴
                from = "up";
            } else {
                // 내 기준 아래에서 들어옴
                from = "down";
            }
        } else if (this.sy != this.pastY) {
            if (this.sy > this.pastY) {
                // 내 기준 왼쪽에서 들어옴
                from = "left";
            } else {
                // 내 기준 오른쪽에서 들어옴
                from = "right";
            }
        }

        // 이전거가 s라면

        switch (here) {
            case "S":

                break;
            case "L":

                break;
            case "R":

                break;

            default:
                break;
        }
    }
}
