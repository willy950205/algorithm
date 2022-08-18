package programmers;

public class Main {
    public static void main(String[] args) {
        ShortestWay2 shortestWay = new ShortestWay2();

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        //int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int result = shortestWay.solution(maps);

        System.out.println(result);

    }
}
