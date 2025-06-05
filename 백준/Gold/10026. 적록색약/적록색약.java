import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char arr[][];
    static boolean vistedNomal[][];
    static boolean vistedEyeAya[][];
    static final int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
    static void dfsAya(int x, int y,char color){
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];

            if(nextX<0||nextX>=N||nextY<0||nextY>=N)continue;
            if(vistedEyeAya[nextX][nextY])continue;
            if(color=='G'||color=='R'){
                if(arr[nextX][nextY]=='G'|| arr[nextX][nextY]=='R'){
                    vistedEyeAya[nextX][nextY]=true;
                    dfsAya(nextX, nextY, color);
                }
            }
            if(color=='B' && color==arr[nextX][nextY]){
                vistedEyeAya[nextX][nextY]=true;
                dfsAya(nextX, nextY, color);
            }
        }
    }
    static void dfsNomal(int x, int y,char color){
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            
            if(nextX<0||nextX>=N||nextY<0||nextY>=N)continue;
            if(vistedNomal[nextX][nextY])continue;
            if(color==arr[nextX][nextY] &&color=='R'){
                vistedNomal[nextX][nextY]=true;
                dfsNomal(nextX, nextY, color);
            }else if(color==arr[nextX][nextY]&&color=='B'){
                vistedNomal[nextX][nextY]=true;
                dfsNomal(nextX, nextY, color);
            }else if(color==arr[nextX][nextY] &&color=='G'){
                vistedNomal[nextX][nextY]=true;
                dfsNomal(nextX, nextY, color);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new char[N][N];
        for(int i=0;i<N;i++){
            arr[i]=br.readLine().toCharArray();
        }
        vistedNomal=new boolean[N][N];
        vistedEyeAya=new boolean[N][N];
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!vistedNomal[i][j]){
                    vistedNomal[i][j]=true;
                    dfsNomal(i, j, arr[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        cnt=0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!vistedEyeAya[i][j]){
                    vistedEyeAya[i][j]=true;
                    dfsAya(i, j, arr[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
