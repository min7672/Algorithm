import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int arr[][];
    static int N;
    static int delta[][]={{0,1},{-1,0},{0,-1},{1,0}};
    static boolean visited[][];
    static int day;
    static void solution(int x, int y){

        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];

            if(nextX<0|| nextY<0 || nextX>=N || nextY >=N)continue;
            if(visited[nextX][nextY])continue;
            if(arr[nextX][nextY]<=day){
                visited[nextX][nextY]=true;
                continue;
            }
            
            visited[nextX][nextY]=true;
            solution(nextX,nextY);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            N= Integer.parseInt(br.readLine());
            arr=new int[N][N];
            visited=new boolean[N][N];
            String []line=new String[N];

            for(int i=0;i < N ; i++){
                line=br.readLine().split(" ");
                for(int j=0;j<N; j++){
                    arr[i][j]=Integer.parseInt(line[j]);
                }
            }
            int result=0;
            for(day=0;day<100;day++){
                /*방문 초기화*/
                visited=new boolean[N][N];
                int ins_cnt=0;
                for(int row=0;row<N;row++){
                    for(int col=0;col<N;col++){
                        /*방문 했던데면*/
                        if(visited[row][col])continue;
                        /*치즈 도둑질 했으면*/

                        if(arr[row][col]<=day){
                            visited[row][col]=true;
                            continue;
                        }else{
                            /*호출 dfs */
                            visited[row][col]=true;
                            solution(row,col);
                            ins_cnt++;
                        }
                    }/*col-종료*/
                }/*row-종료*/
                if(ins_cnt>result)result=ins_cnt;
            }/*day-종료*/
            System.out.printf("#%d %d\n",test_case,result);
        }
    }   
}
