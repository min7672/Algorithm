import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class Main {
    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static ArrayList<Point> curList;
    static ArrayList<Integer> rmList;
    static final int delta[][]={{-1,0},{0,-1},{1,0},{0,1}};
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void changeArr(int x,int y,int k){
        Queue<Point> works=new ArrayDeque<>();
        works.add(new Point(x, y));
        visited[x][y]=true;
        while(!works.isEmpty()){
            Point cur=works.poll();

            for(int i=0;i<4;i++){
                int nextX=cur.x+delta[i][0];
                int nextY=cur.y+delta[i][1];
                if(nextX<0 || nextY<0 ||  nextX>=N||nextY>=M)continue;
                if(visited[nextX][nextY])continue;
                if(arr[nextX][nextY]==2){
                    arr[nextX][nextY]=0;
                }
                if(k==0){
                    /*외부공기 */
                    if(arr[nextX][nextY]<1){
                        visited[nextX][nextY]=true;
                        works.add(new Point(nextX, nextY));
                    }
                }else if(k==1){
                    /*내부공기 */
                    if(arr[nextX][nextY]<1){
                        visited[nextX][nextY]=true;
                        works.add(new Point(nextX, nextY));
                        arr[nextX][nextY]=2;
                    }
                }
            }
        }
    }
    static ArrayList<Integer> cntCheese(){      
        ArrayList<Integer> removeCheese=new ArrayList<>();
        
        for(int i=curList.size()-1; i>=0;i--){
            Point cur=curList.get(i);
            if(cntArr(cur.x, cur.y)>=2){
                removeCheese.add(i);
            }
        }
        
        return removeCheese;
    }
    static int cntArr(int x, int y){
        int cnt=0;
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            if(nextX<0 || nextY<0 ||  nextX>=N||nextY>=M)continue;
            if(arr[nextX][nextY]==0)cnt++;
        }
        
        return cnt;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        String line[]=new String[M];
        arr=new int[N][M];
        curList=new ArrayList<>();

        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
                if(arr[i][j]==1){
                    curList.add(new Point(i, j));
                }
            }
        }

        rmList=new ArrayList<>();

        int cnt=curList.size();
        int result=0;
        

        while(cnt!=0){
            /*공기 구분 */
            visited=new boolean[N][M];
            changeArr(0,0,0);
            
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    changeArr(i,j, 1);
                }
            }
            /*치즈 세기 */
            
            rmList.clear(); 
            rmList=cntCheese();
            
            
            /*치즈 빼기 */
            for(int i : rmList){
                Point cur=curList.get(i);
                arr[cur.x][cur.y]=0;
                curList.remove(i);
                cnt--;
            }
        
            result++;
        }
        System.out.println(result);
    }
}