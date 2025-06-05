import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Solution {
    static boolean visited[][];
                        /* 우 하 좌 상 */
    static int delta[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static int dir=0;
    static boolean exit;
    static boolean isIn(int arr[][],int x,int y){
        if(x>=0&&x<arr.length&&y>=0&&y<arr.length)return true;
        return false;
    }
    static void snail(int arr[][], int n,int x,int y){
            
            if(exit)return;
            if(n== arr.length*arr.length){
                exit=true;
            }
            /*가야 할 방향 조사1, */
            for(int i=dir;i<4+dir;i++){
                int nextX=x+delta[i%4][0];
                int nextY=y+delta[i%4][1];

                if(isIn(arr,nextX,nextY)){
                    if(!visited[nextX][nextY]){       
                        /*가야 할 방향 조사1, 갈수 있는지 조사 */
                        visited[nextX][nextY]=true;
                        arr[nextX][nextY]=n;
                        dir=i%4;
                        snail(arr,n+1,nextX,nextY);
                    }
                }
            }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N=Integer.parseInt(br.readLine());
            /*입력 끝 */

            int [][]arr=new int[N][N];
            /*전역으로 쓴 변수 초기화 */
            visited=new boolean[N][N];
            arr[0][0]=1;
            visited[0][0]=true;
            exit=false;
            
            
            snail(arr,2,0,0);

            /*출력 */
            System.out.printf("#%d\n",test_case);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println("");
            }
        }
    }
}