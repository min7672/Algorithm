import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        char arr[][]=new char[N][M];
        for(int i=0;i<N;i++){
            arr[i]=br.readLine().toCharArray();
        }
        boolean visited[][]=new boolean[N][M];
        Queue<Point> works=new ArrayDeque<>();
        works.add(new Point(0, 0, 0));
        visited[0][0]=true;
        int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while (!works.isEmpty()) {
            Point cur=works.poll();
            if(cur.x ==N-1 && cur.y ==M-1){
                System.out.println(cur.depth+1);
                break;
            }
            for(int i=0;i<4;i++){
                int nextX=cur.x+delta[i][0];
                int nextY=cur.y+delta[i][1];
                if(nextX<0 || nextY<0 || nextX>=N || nextY>=M)continue;
                if(visited[nextX][nextY] )continue;
                if(arr[nextX][nextY]=='1'){
                    visited[nextX][nextY]=true;
                    works.add(new Point(nextX, nextY, cur.depth+1));
                }
            }
        }
    } 
}
