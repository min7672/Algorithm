import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,W,H;
    static int arr[][];
    static BufferedReader br;
    static ArrayList<Integer> wList;
    static int []targets;
    static int clone[][];
    static int result;
    static final int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
    static boolean visited[][];
        static class Point{
        public int x;
        public int y;
        public int range;
        Point(int x, int y, int range){
            this.x=x;
            this.y=y;
            this.range=range;
        }

    }
    static void init() throws IOException{
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        arr=new int[H][W];
        targets=new int[W];
        wList=new ArrayList<>();
        result=Integer.MAX_VALUE;
        
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return;
    }
    static void solution(int idx){
        if( idx==N){
            
            clone=new int[H][W];
            for(int i=0;i<H;i++){
                clone[i]=arr[i].clone();
                
            }
            for(int i=0;i<wList.size();i++){
                int l=wList.get(i);
                gravityPlus();
                // System.out.println( l+ " "+ targets[l]);
                explotion(targets[l],l);
            }
            int cnt=0;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(clone[i][j]!=0)cnt++;
                }
            }
            
            result=Math.min(result, cnt);
            return;
        }
        
        for(int i=0;i<W;i++){
            wList.add(i);
            solution(idx+1);
            wList.remove(idx);
            
        }
    }
    static void gravityPlus(){
        for(int j=0;j<W;j++){
            int writePos = H - 1; 
            for(int i=H-1;i>=0;i--){
                if (clone[i][j] != 0) {
                    clone[writePos][j] = clone[i][j];
                    if (writePos != i) {
                        clone[i][j] = 0;
                    }
                    writePos--;
                }
            }
            
                targets[j] = writePos + 1;
            
        }
        
    }



    static void explotion(int x, int y){
        Queue<Point> works=new ArrayDeque<>();
        if(x==H)return;
        works.add(new Point(x, y, clone[x][y]));
        visited=new boolean[H][W];
        visited[x][y]=true;
        while(!works.isEmpty()){
            Point cur=works.poll();
            clone[cur.x][cur.y]=0;
            for(int i=0;i<4;i++){
                for(int j=0;j<cur.range;j++){
                    int nx=cur.x+delta[i][0]*j;
                    int ny=cur.y+delta[i][1]*j;
                    if(nx>=0&&ny>=0&&nx<H &&ny<W &&!visited[nx][ny] ){
                        visited[nx][ny]=true;
                        works.add(new Point(nx, ny, clone[nx][ny]));
                    }   
                }
            }
        }
        
        

    }
    public static void main(String[] args) throws IOException{
        br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            init();
        solution(0);
        System.out.printf("#%d %d\n",test_case,result);
        }
        
        
        

        
        // solution(0);
        
        // System.out.println(Arrays.toString(targets));
    }
}