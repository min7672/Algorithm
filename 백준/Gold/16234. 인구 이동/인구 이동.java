import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int N,L,R;  
    static boolean visited[][];  
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

    }
    static boolean bfs(int x, int y){
        
        Queue<Point> works = new LinkedList<>();
        ArrayList<Point> result=new ArrayList<>();
        visited[x][y]=true;
        result.add(new Point(x, y));
        works.add(new Point(x, y));
        int sum=arr[x][y];
        int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};

        
        while(!works.isEmpty()){
            Point cur=works.poll();
            
            for(int i=0;i<4;i++){
                int nextX=cur.x+ delta[i][0];
                int nextY=cur.y+ delta[i][1];
                
                if(nextX<0|| nextX>=N||nextY<0|| nextY>=N)continue;
                
                if(visited[nextX][nextY])continue;
                
                
                int b=arr[nextX][nextY]-arr[cur.x][cur.y];
                b=Math.abs(b);
                
                if(b>=L && b<=R){
                    visited[nextX][nextY]=true;    
                    sum+=arr[nextX][nextY];
                    works.add(new Point(nextX, nextY));    
                    result.add(new Point(nextX, nextY));
                }
            }

        }
        int size=result.size();
        for(int i=0;i<size;i++){
            Point cur=result.get(i);
            
            arr[cur.x][cur.y]=sum/size;
            
        }
        
        if(size>1)return false;

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }   
        }
        boolean checker=false;
        
        
        int result=0;
        int cnt=1;
        while(cnt!=0){
            visited=new boolean[N][N];
            cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    
                    if(!visited[i][j]){
                        checker=bfs(i, j);
                        if(!checker)cnt++;
                    }
                }/*완탐*/
            }

            if(cnt>0){result++;}
            

        }/*일 수*/
        System.out.println(result);
    }

}
