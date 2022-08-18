package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon15686Sencond {
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static List<Index> chicken;
    static List<Index> house;
    static boolean[] open;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input1 = br.readLine();
        N = Integer.parseInt(input1.split(" ")[0]);
        M = Integer.parseInt(input1.split(" ")[1]);
        chicken = new ArrayList<Index>();
        house = new ArrayList<Index>();


        int[][] city = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input2 = br.readLine();
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(input2.split(" ")[j]);
                if (city[i][j] == 2) {
                    Index index = new Index(i, j);
                    chicken.add(index);
                } else if (city[i][j] == 1) {
                    Index index = new Index(i, j);
                    house.add(index);
                }
            }
        }

        open = new boolean[chicken.size()];

        search(0, 0);

        System.out.println(answer);
    }

    static public void search(int start, int cnt) {

        if (M == cnt) {

            int result = 0;

            for (int i = 0; i < house.size(); i++) {

                int min = minDis(house.get(i));
                result += min;
            }

            answer = Integer.min(answer, result);
            return;

        }

        for (int i = 0; i < open.length; i++) {
            open[i] = true;
            search(i + 1, cnt + 1);
            open[i] = false;
        }

    }

    static public int minDis(Index hse) {

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < open.length; i++) {
            if (open[i]) {

                Index chick = chicken.get(i);
                result = Integer.min(result, Math.abs(hse.col - chick.col) + Math.abs(hse.row - chick.row));
            }
        }
        return result;
    }


}

class Index {

    int col;
    int row;

    public Index(int col, int row) {
        // TODO Auto-generated constructor stub
        this.col = col;
        this.row = row;
    }
}


