import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point{
        public int x;
        public int y; 
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            String info[]=br.readLine().split(" ");
            int N=Integer.parseInt(info[0]);
            int M=Integer.parseInt(info[1]);
            int K=Integer.parseInt(info[2]);
            int arr[][]= new int[N][M];
            String []line=new String[2];
            ArrayList<Point> vegetables=new ArrayList<Point>();
            for(int i=0;i< K;i++){
                line=br.readLine().split(" ");
                int x=Integer.parseInt(line[0]);
                int y=Integer.parseInt(line[1]);
                arr[x][y]+=1;
                vegetables.add(new Point(x, y));
            }
            boolean visitied[][]=new boolean[N][M];
            Queue<Point> works=new LinkedList<>();
            int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
            int cnt=0;
            for(int i=0;i<K;i++){   
                Point tmp=vegetables.get(i);
                if(visitied[tmp.x][tmp.y])continue;
                works.add(vegetables.get(i));
                cnt++;
                while(!works.isEmpty()){
                    Point cur=works.poll();
                    visitied[cur.x][cur.y]=true;

                    for(int j=0;j<4;j++){
                        int nextX=cur.x+delta[j][0];
                        int nextY=cur.y+delta[j][1];
                        if(nextX>=0 && nextX<N &&nextY>=0 && nextY<M&&!visitied[nextX][nextY] &&arr[nextX][nextY]==1){
                            visitied[nextX][nextY]=true;
                            works.add(new Point(nextX, nextY));
                        }
                    }
                }

            }
            System.out.println(cnt);
        }
    }
}
