import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean visited[][];
    static int N;
    static int M;
    static int arr[][];
    static int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
    
    static int dir=0;
    static int tmp=0;
    static void solution( int x, int y,int startX, int startY,int n, int m){
        
        int nextX=x+delta[dir][0];
        int nextY=y+delta[dir][1];
        
        if(nextX>=startX&& nextX<n && nextY>=startY &&nextY<m){
            
            if(!visited[nextX][nextY]){
                int ins_tmp=arr[nextX][nextY];
                arr[nextX][nextY]=tmp;
                tmp=ins_tmp;
                
                visited[nextX][nextY]=true;
                
                solution(nextX, nextY, startX,startY,n,m);
            }
        }else{
            dir=(dir+1)%4;
            solution(x, y, startX,startY, n,m);
        }
        

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]= br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        int K=Integer.parseInt(info[2]);
        arr=new int[N][M];
        visited=new boolean[N][M];
        String line[]=new String[M];
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }
        for(int z=0;z<K;z++){
            visited=new boolean[N][M];
            
            dir=0;
            int base=N;
            if(base>M)base=M;
            for(int i=0;i<Math.floor(base/2.0);i++){
                dir=0;
                tmp=arr[i][i];
                visited[i][i]=true;
                solution(i,i,i,i,N-i,M-i);
                
                arr[i][i]=tmp;
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println("");
        }
    }   
}
