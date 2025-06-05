import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static boolean visited[][];
    static int arr[][];
    static int delta[][]={{-1,0},{1,0},{0,-1},{0,1}};
    
    static class Point{
        public int x;
        public int y;
        public int visitCnt;
        Point(int x, int y,int cnt){
            this.x=x;
            this.y=y;
            this.visitCnt=cnt;
        }
    }
    static Point ins_point;
    static Point max_point;
    static void solution(int x, int y){
        // System.out.println("("+x+", "+y+")");
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];

            if(nextX<0|| nextY<0 || nextX>=N || nextY >=N)continue;
            
            if(visited[nextX][nextY])continue;

            
            if(arr[nextX][nextY]==arr[x][y]+1){

                ins_point.visitCnt++;
                
                solution(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            N=Integer.parseInt(br.readLine());
            String line[]=new String[N];
            arr=new int[N][N];
            
            
            for(int i=0;i<N;i++){
                line=br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(line[j]);
                }
            }
            
            

            
            visited=new boolean[N][N];
            visited[0][0]=true;
            ins_point=new Point(0,0,1);
            solution(0,0);
            max_point=new Point(0, 0, ins_point.visitCnt);
            
            for(int i=1;i<N;i++){
                
                for(int j=0;j<N;j++){
                    visited=new boolean[N][N];
                    visited[i][j]=true;
                    ins_point=new Point(i,j,1);
                    solution(i,j);
                    
                    if(ins_point.visitCnt>max_point.visitCnt){
                        max_point.visitCnt=ins_point.visitCnt;
                        max_point.x=i;
                        max_point.y=j;
                    }else if(ins_point.visitCnt==max_point.visitCnt){
                        if(arr[ins_point.x][ins_point.y]<arr[max_point.x][max_point.y]){
                            max_point.x=i;
                            max_point.y=j;
                        }
                    }

                    
                }
            }
            System.out.printf("#%d %d %d\n",test_case,arr[max_point.x][max_point.y], max_point.visitCnt);
        }
    }
}
