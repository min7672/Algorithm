import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    

    static class Point{
        public int x;
        public int y;
        public int depth;
        Point(int x, int y, int depth){
            this.x=x;
            this.y=y;
            this.depth=depth;
        }   

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String []info=br.readLine().split(" ");
        int M=Integer.parseInt(info[0]);
        int N=Integer.parseInt(info[1]);
        String []line=new String[M];
        int arr[][]=new int[N][M];
        Queue<Point> works=new LinkedList<>();
        int cnt=0;
        
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
                if(arr[i][j]!=0)cnt++;
                if(arr[i][j]==1){
                    works.add(new Point(i, j, 0));
                    
                }
                
            }
        }
        boolean visited[][]=new boolean[N][M];
        int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int result=0;

        
        while(!works.isEmpty()){
            Point cur=works.poll();
            visited[cur.x][cur.y]=true;
            for(int i=0;i<4;i++){
                int nextX=cur.x+delta[i][0];
                int nextY=cur.y+delta[i][1];

                if(nextX<0|| nextY<0 || nextX>=N||nextY>=M)continue;
                if(visited[nextX][nextY])continue;
                
                if(arr[nextX][nextY]==0){
                    cnt++;
                    if(result<cur.depth+1)result=cur.depth+1;
                    visited[nextX][nextY]=true;
                    works.add(new Point(nextX, nextY, cur.depth+1));
                }
            }

        }
        
        if(cnt!=N*M){
            System.out.println("-1");
        }else{
            System.out.println(result);
        }

    }
}
