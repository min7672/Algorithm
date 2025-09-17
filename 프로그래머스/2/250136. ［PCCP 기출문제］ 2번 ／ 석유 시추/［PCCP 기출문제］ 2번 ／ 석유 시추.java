import java.util.ArrayDeque;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
        public int getR(){
            return this.r;
        }
        
        public int getC(){
            return this.c;
        }
    }
    public static int solution(int[][] land) {
        int answer = 0;
        int n=land.length;
        int m=land[0].length;
        int visited[][]=new int[n][m];
        int delta[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int key=1;
        Queue<Point> queue=new ArrayDeque();
        HashMap<Integer, Integer> vMap=new HashMap<>();
        int insValue=0;
        boolean checker=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                checker=false;
                if(land[i][j]==1 && visited[i][j]==0){
                    queue.add(new Point(i,j));
                    visited[i][j]=key;
                    insValue=1;
                    checker=true;
                }
                while(!queue.isEmpty()){
                    Point cur=queue.poll();
                    for(int k=0;k<4;k++){
                        int nextX=cur.getR()+delta[k][0];
                        int nextY=cur.getC()+delta[k][1];
                        if(nextX>=0&& nextY>=0 && nextX<n &&nextY<m && land[nextX][nextY]==1 && visited[nextX][nextY]==0){
                            visited[nextX][nextY]=key;
                            insValue++;
                            queue.add(new Point(nextX, nextY));
                        }
                    }
                }
                if(checker)vMap.put(key++, insValue);
                
            }
        }
        
        HashSet<Integer> set=new HashSet<>();
        int ins_result=0;
        for(int j=0;j<m;j++){
            set.clear();
            ins_result=0;
            for(int i=0;i<n;i++){
                if(visited[i][j]!=0)set.add(visited[i][j]);
            }
            for(int x:set){
                ins_result+=vMap.get(x);
            }
            
            answer=Math.max(ins_result,answer);
        }
       
        return answer;
    }

        


}