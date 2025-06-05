import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R,C;
    static char arr[][];
    static int result,ins_cnt;
    static int delta[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static boolean visited[][];
    static boolean used[];
    static void solution(int x, int y){

        
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];

            if(nextX<0 || nextX>=R ||nextY<0 ||nextY>=C)continue;
            if(visited[nextX][nextY])continue;  
            if(used[arr[nextX][nextY]-65])continue;

            visited[nextX][nextY]=true;
            used[arr[nextX][nextY]-65]=true;
            ins_cnt++;
            if(ins_cnt>result)result=ins_cnt;
            solution(nextX, nextY);
            visited[nextX][nextY]=false;
            used[arr[nextX][nextY]-65]=false;
            ins_cnt--;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        R=Integer.parseInt(info[0]);
        C=Integer.parseInt(info[1]);
        arr=new char[R][C];
        visited=new boolean[R][C];
        for(int i=0;i<R;i++){
            arr[i]=br.readLine().toCharArray();
        }
        used=new boolean[26];
        visited[0][0]=true;
        used[arr[0][0]-65]=true;
        result=1;
        ins_cnt=1;
        solution(0,0);  
        System.out.println(result);

    }
}

