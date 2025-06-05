import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    static int R;
    static int C;
    static boolean visited[][];
    static int arr[][];
    static int insCnt;
    static int preCnt;
    
    static int delta[][]={{0,1},{-1,0},{0,-1},{1,0}};
    static ArrayList<Point> curList;
    static void dfs(int x, int y){

        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];

            if(nextX<0|| nextY<0 || nextX>=R || nextY >=C)continue;
            if(visited[nextX][nextY])continue;
            if(arr[nextX][nextY]==1){
                visited[nextX][nextY]=true;
                curList.add(new Point(nextX, nextY));
                continue;
            }
            
            insCnt++;
            visited[nextX][nextY]=true;
            
            dfs(nextX,nextY);
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        R=Integer.parseInt(info[0]);
        C=Integer.parseInt(info[1]);
        String line[]=new String[C];
        arr=new int[R][C];
        for(int i=0;i<R;i++){
            line=br.readLine().split(" ");
            for(int j=0;j<C; j++){
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }
        
        curList=new ArrayList<>();
        
        Point tmp=null;
        int result=-1;
        preCnt=0;
        int preCircle=0;
        while(insCnt!=R*C){
            preCircle=R*C-(curList.size()+insCnt);
            preCnt=insCnt;

            visited= new boolean[R][C];
            curList.clear();
            insCnt=1;
            visited[0][0]=true;
            dfs(0,0);
            
            
            /* 녹인다 */
            for(int i=0;i<curList.size();i++){
                tmp=curList.get(i);
                arr[tmp.x][tmp.y]=0;
            }
            /*1시간이 흘렀다*/
            result++;
             
        }
        System.out.println(result);
        
        System.out.println(R*C-preCnt-preCircle);
        
        


    }
}
