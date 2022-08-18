package programmers;

public class ShortestWay {

    // dfs로 풀었다.
    // 효율성 문제로 실패

    int [][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] maps) {

        boolean [][] mapsCheck = new boolean[maps.length][maps[0].length];

        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length; j++){
                if(maps[i][j]==1){
                    mapsCheck[i][j]=true;
                }else{
                    mapsCheck[i][j]=false;
                }
            }
        }

        find(0,0,1, mapsCheck);

        if(answer==Integer.MAX_VALUE) return -1;

        return answer;
    }

    public void find(int x, int y, int length, boolean [][] mapsCheck){

        if(y<0 || x<0 || x>=mapsCheck.length || y>=mapsCheck[0].length || !mapsCheck[x][y]){
            return;
        }

        if(x==mapsCheck.length-1 && y==mapsCheck[0].length-1){
            answer = Integer.min(answer, length);
            return;
        }

        length++;
        mapsCheck[x][y]=false;

        for(int[] dir : direction){
            find(x+dir[0], y+dir[1], length, mapsCheck);
        }

    }
}
