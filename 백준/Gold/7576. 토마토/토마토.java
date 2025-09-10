import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static class Point{
        public int r;
        public int c;
        public int depth;
        public Point(int r, int c, int depth){
            this.r=r;
            this.c=c;
            this.depth=depth;
        }
    }

    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        
        boolean visited[][]=new boolean[N][M];
        
        Queue<Point> queue=new ArrayDeque<>();
        int arr[][]=new int[N][M];
        int visit_cnt=0;
        int wall_cnt=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                
                if(arr[i][j]==1){
                    queue.add(new Point(i, j, 0));
                    visited[i][j]=true;
                    visit_cnt++;
                }else if(arr[i][j]==-1){
                    wall_cnt++;
                }
                
            }
            
        }
        int delta[][]={{1,0},{0,1}, {-1,0},{0,-1}};
        int result=0;

        while (!queue.isEmpty()) {
            Point cur=queue.poll();
            
            for(int i=0;i<4;i++){
                
                int nextX=delta[i][0]+cur.r;
                int nextY=delta[i][1]+cur.c;
                if(nextX<0||nextX>=N ||nextY<0 ||nextY>=M)continue;
                
                if(arr[nextX][nextY]==0 && !visited[nextX][nextY]){
                    visited[nextX][nextY]=true;
                    queue.add(new Point(nextX,nextY,cur.depth+1));
                    visit_cnt++;
                    result=(result<cur.depth+1)? cur.depth+1:result;
                }

            }
            
        }
        result=(N*M==visit_cnt+wall_cnt)? result:-1;
        System.out.println(result);
        
    }
}