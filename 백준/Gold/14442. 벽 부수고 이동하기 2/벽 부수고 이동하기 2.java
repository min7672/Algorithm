import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static class Point{
        public int x;
        public int y;
        public int wall;
        public int depth;
        Point(int x, int y, int wall, int depth){
            this.x=x;
            this.y=y;
            this.wall=wall;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []info=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        int K=Integer.parseInt(info[2]);
        char arr[][]=new char[N][M];
        
        for(int i=0;i<N;i++){
            arr[i]=br.readLine().toCharArray();
        }

        boolean visited[][][]=new boolean[N][M][K+1];
        int delta[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Point> works=new ArrayDeque<>();
        works.add(new Point(0, 0, 0, 1));

        while(!works.isEmpty()){
            Point cur= works.poll();
            // System.out.println(cur.x + " , " + cur.y + " " + cur.wall + " , " + cur.depth);
            if(cur.x==N-1 && cur.y==M-1){
                System.out.println(cur.depth);
                return;
            }
            for(int i=0;i<4;i++){
                int nx=cur.x+delta[i][0];
                int ny=cur.y+delta[i][1];
                
                if(nx<0||ny<0 ||nx>=N ||ny>=M)continue;
                
                if( !visited[nx][ny][cur.wall] &&arr[nx][ny]=='0'){
                    visited[nx][ny][cur.wall] = true;
                    works.add(new Point(nx, ny, cur.wall, cur.depth+1));
                }
                if( cur.wall<K && !visited[nx][ny][cur.wall+1] && arr[nx][ny]=='1'){
                    visited[nx][ny][cur.wall+1]=true;
                    works.add(new Point(nx, ny, cur.wall+1, cur.depth+1));
                }

            }
        }
        System.out.println("-1");

        
    }
}
