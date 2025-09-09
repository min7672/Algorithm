import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int [][]arr;
    static boolean [][]clean;
    static int N,M;
    static int delta[][]={{-1,0},{0,1},{1,0},{0,-1}};

    //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
    static boolean is_blank(int x, int y){
        
        boolean result=false;
        for(int i=0;i<4;i++){
            int nextX=delta[i][0]+x;
            int nextY=delta[i][1]+y;
            if(nextX<0 || nextY<0 || nextX>=N ||nextY>=M)continue;

            if(arr[nextX][nextY]==0 && !clean[nextX][nextY]){
                result=true;
                break;
            }

        }
        return result;
    }
    public static void main(String[] args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                
            }
        }
        int result=0;
        clean=new boolean[N][M];

        /*  0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽 */
        while(true){
            //1. 현재 칸이 아직 청소되지 않은 빈칸인 경우 현재 칸을 청소한다.
            if(arr[r][c]==0 && !clean[r][c]){
                result++;
                clean[r][c]=true;
            }
            /*2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, */
            if(!is_blank(r, c)){
                int back=(d+2)%4;
                int nextX=delta[back][0]+r;
                int nextY=delta[back][1]+c;
                /* 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한칸 후진하고 1번으로 돌아간다. */
                if(nextX>=0 && nextY>0 && nextX<N &&nextY<M &&arr[nextX][nextY]==0){
                    r=nextX;
                    c=nextY;
                }else{
                    /*2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다. */
                    break;
                }
            }else{
                
                int left=(d+3)%4;
                /*3-1. 반시계 방향으로 90도 회전한다. */
                d=left;
                int nextX=delta[left][0]+r;
                int nextY=delta[left][1]+c;
                /*3-1. 바라보는 방향 기준으로 앞쪽 칸이 청소되지 않은 빈 칸 인경우 한 칸 전진한다. */
                if(nextX>=0 && nextY>0 && nextX<N &&nextY<M &&arr[nextX][nextY]==0 && !clean[nextX][nextY]){
                    r=nextX;
                    c=nextY;
                }
            }
        }
        System.out.println(result);    
    }


}