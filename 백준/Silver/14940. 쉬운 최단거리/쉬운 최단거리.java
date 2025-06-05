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
        Point(int x,int y,int depth){
            this.x=x;
            this.y=y;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        String line[]=new String[M];
        int arr[][]=new int[N][M];
        Queue<Point> works=new LinkedList<>();
        for(int i=0;i<N; i++){
            line=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
                if(arr[i][j]==2){
                    arr[i][j]=0;
                    works.add(new Point(i, j,0));
                }else if(arr[i][j]==1){
                    arr[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        boolean visited[][]=new boolean[N][M];
        int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!works.isEmpty()){
            Point cur=works.poll();
            for(int i=0;i<4;i++){
                int x=cur.x+delta[i][0];
                int y=cur.y+delta[i][1];
                if(x>=0 && y>=00 && N>x && M>y && !visited[x][y] && arr[x][y]==Integer.MAX_VALUE){
                    visited[x][y]=true;
                    if(arr[x][y]>cur.depth+1){
                        arr[x][y]=cur.depth+1;
                    }
                    
                    works.add(new Point(x, y, cur.depth+1));
                }
            }
        }
        for(int i=0;i<N; i++){
            
            for(int j=0;j<M;j++){
                if(arr[i][j]==Integer.MAX_VALUE){
                    System.out.print("-1 ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
    }
}