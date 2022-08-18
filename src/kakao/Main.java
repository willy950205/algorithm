package kakao;

public class Main {

    public static void main(String[] args) {


        Second a = new Second();

        int needs[][] = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};

        a.solution(needs, 2);

    }

}
