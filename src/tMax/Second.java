package tMax;

public class Second {
    int [][]costs;
    int xcost;
    int ycost;

    public int solution(int [][]costs, int xcost, int ycost){
        this.costs=costs;
        this.xcost=xcost;
        this.ycost=ycost;

        int answer = find(0,0,costs[0][0], -1);
        return answer;

    }

    public int find(int x, int y, int learn, int move){

        int cost = 0;
        switch (move){
            case -1:
                cost = 0;
                break;
            case -2:
                cost = xcost+ycost;
                break;
            case -3:
                cost = xcost;
                break;
            case -4:
                cost = ycost;
                break;
        }

        if(x==0 && y==0){
            learn = learn - cost;
        }else{
            learn = costs[y][x] + learn - cost;
        }


        int result = 0;
        if(x==0 && y==0){
            int resultX = find(x+1, y, learn, -3);
            int resultY = find(x, y+1, learn, -4);
            int temp = Integer.max(resultX,resultY);
            result = Integer.max(temp, learn);
        }else if(x==costs.length-1 && y<costs[0].length-1){
            int resultY = find(x, y+1, learn, -4);
            result = Integer.max(resultY, learn);
        }else if(x<costs.length-1 && y==costs[0].length-1){
            int resultX = find(x+1, y, learn, -3);
            result = Integer.max(resultX, learn);
        }else if(x<costs.length-1 && y<costs[0].length-1){
            int resultX = find(x+1, y, learn, -3);
            int resultY = find(x, y+1, learn, -4);
            int temp = Integer.max(resultX,resultY);
            result = Integer.max(temp, learn);
        }else if(x==costs.length-1 && y==costs[0].length-1){
            result = learn;
        }

        return result;
    }


}
