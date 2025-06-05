import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N,K;
    static int arr[][];
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
    static boolean digCheck;
    static boolean visited[][];
    static int ins_depth;
    static int result=0;
    static void dfs(int x, int y){
        if(ins_depth>result)result=ins_depth;
        for(int i=0;i<4;i++){
            int nx=x+delta[i][0];
            int ny=y+delta[i][1];

            if(nx<0 || ny<0 || nx>=N || ny>=N)continue;
            if(visited[nx][ny])continue;
            if(arr[nx][ny]<arr[x][y]){
                /*정상적으로 진행할때*/
                visited[nx][ny]=true;
                ins_depth++;
                dfs(nx,ny);
                visited[nx][ny]=false;
                ins_depth--;
            }else{
                /*깎을 수 있을때*/
                if(!digCheck && (arr[x][y]-1>=arr[nx][ny]-K)){
                    int tmp=arr[nx][ny];
                    arr[nx][ny]=arr[x][y]-1;
                    digCheck=true;
                    visited[nx][ny]=true;
                    ins_depth++;
                    dfs(nx,ny);
                    arr[nx][ny]=tmp;
                    digCheck=false;
                    ins_depth--;
                    visited[nx][ny]=false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        for(int test_case=1;test_case<=T;test_case++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            arr=new int[N][N];

            ArrayList<Point> tops=new ArrayList<>();
            int top_value=0;

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]> top_value)top_value=arr[i][j];
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if( arr[i][j]==top_value)tops.add(new Point(i, j));
                }
            }
            result=1;
            for(int i=0;i<tops.size();i++){
                Point top=tops.get(i);
                visited=new boolean[N][N];
                digCheck=false;
                visited[top.x][top.y]=true;
                ins_depth=1;
                dfs(top.x, top.y);
            }
            System.out.printf("#%d %d\n",test_case,result);
        }
    }
}