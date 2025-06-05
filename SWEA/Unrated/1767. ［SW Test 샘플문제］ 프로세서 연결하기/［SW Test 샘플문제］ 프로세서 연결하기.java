import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Point{
        public int r;
        public int c;

        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
    static int N;
    static int arr[][];
    static ArrayList<Point> cores;
    static boolean visited[];
    static int ins_cnt, ins_length;
    static int coreMax,lenghMin;
    static int size;
    static ArrayList<Integer> curList;

    static void solution(int idx){
        if(idx==size) {
            if(ins_cnt>coreMax){
                coreMax=ins_cnt;
                lenghMin=ins_length;
            }else if(ins_cnt==coreMax && ins_length<=lenghMin){
                lenghMin=ins_length;
            }
            return;
        }
        Point cur=cores.get(idx);
        
        /*4방 라인 넘기기 */
        for(int i=0;i<4;i++){

            /*라인이 안막혀있으면 라인 그리기 */
            int len=calculate(cur.r, cur.c, i,2);
            if(len==-1){
                
                continue;
            }
            // System.out.println(len);
            
            visited[idx]=true;
            ins_cnt++;
            ins_length+=len;
            curList.add(idx);
            solution(idx+1);
            curList.remove(curList.size()-1);
            ins_cnt--;
            /*라인 걷어내기*/
            calculate(cur.r, cur.c, i,0);
            ins_length-=len;
            visited[idx]=false;
            
        }
        // 현재 코어를 연결하지 않고 넘어가는 경우
        solution(idx + 1);
    }
    static int calculate(int x, int y, int dir,int num){
        int result=0;
        boolean checker=false;
        int compare=0;
        if(num==0){
            compare=2;
        }else{
            compare=0;
        }
        while((x>=0 && y>=0 && x<N && y<N)){
            x+=delta[dir][0];
            y+=delta[dir][1];
            if (x < 0 || y < 0 || x >= N || y >= N) break; // 경계 체크
            
            if(arr[x][y]==compare){
                arr[x][y]=num;
                result++;
            }else{
                checker=true;
                break;
            }
            
        }
        if(checker){
            for(;result>0;result--){
                x-=delta[dir][0];
                y-=delta[dir][1];
                arr[x][y]=0;
            }
            return -1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            N=Integer.parseInt(br.readLine());
            StringTokenizer st=null;
            arr=new int[N][N];
            
            cores=new ArrayList<>();
            
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1){
                        if( i!=0 && i!=N-1 && j!=0 && j!=N-1  ){
                            cores.add(new Point(i, j));
                        }
                    }
                }   
            }
            
            
            coreMax=Integer.MIN_VALUE;
            lenghMin=Integer.MAX_VALUE;
            visited=new boolean[cores.size()];
            size=cores.size();
            curList=new ArrayList<>();
            ins_cnt=0;
            ins_length=0;
            solution(0);
            System.out.printf("#%d %d\n",test_case, lenghMin);
        }
    }
}