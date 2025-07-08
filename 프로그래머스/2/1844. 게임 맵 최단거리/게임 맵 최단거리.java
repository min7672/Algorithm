import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static class Point{
        public int x;
        public int y;
        public int depth;
        Point(int x, int y,int depth){
            this.x=x;
            this.y=y;
            this.depth=depth;
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        int n=maps.length;
        int m=maps[0].length;
        boolean visited[][]=new boolean[n][m];
        int delta[][]={{-1,0},{0,-1},{1,0},{0,1}};

        Queue<Point> bfs=new ArrayDeque<Point>(); 
        bfs.add(new Point(0,0,1));
        visited[0][0]=true;
        while(!bfs.isEmpty()){
            Point cur=bfs.poll();
            if(cur.x==n-1 && cur.y==m-1){
                answer=cur.depth;
                break;
            }
            for(int i=0;i<4;i++){
                int nextX=cur.x+delta[i][0];
                int nextY=cur.y+delta[i][1];
                if(nextX<0 ||nextY<0 ||nextX>=n || nextY>=m)continue;
                if(!visited[nextX][nextY] && maps[nextX][nextY]==1){
                    bfs.add(new Point(nextX, nextY, cur.depth+1));
                    visited[nextX][nextY]=true;
                }
            }
        }

        return answer;
    }
}