import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
     * 9P3 모두 생성 
     * 각 숫자 검사, 일지하는 숫자 담기
     */
    static boolean visited[];
    static List<Integer> list;
    static int N,cnt;
    static int nums[][];
    static int strike[];
    static int ball[];
    public static void main(String[] args) throws IOException{
        init();
        solve();
    }
    static void init()throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer("");
        nums=new int[N][3];
        strike=new int[N];
        ball=new int[N];
        char tmp[]=new char[3];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            tmp=st.nextToken().toCharArray();
            nums[i][0]=(int)tmp[0]-48;
            nums[i][1]=(int)tmp[1]-48;
            nums[i][2]=(int)tmp[2]-48;
            strike[i]=Integer.parseInt(st.nextToken());
            ball[i]=Integer.parseInt(st.nextToken());
        }
        br.close();
        visited=new boolean[10];
        list=new ArrayList<Integer>();

    }
    static void solve() {
        makeNum(0);
        System.out.println(cnt);
    }
    static void makeNum(int idx){
        //종료 조건
        if(idx==3){
            if(isCondition())cnt++;
            return;
        }
        for(int i=1;i<=9;i++){
            if(visited[i])continue;
            visited[i]=true;
            list.add(i);
            makeNum(idx+1);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
    static boolean isCondition(){
    
        for(int i=0;i<N;i++){
            int ball_cnt=0;
            int strike_cnt=0;
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(j==k && nums[i][j]==list.get(k))strike_cnt++;        
                    if(j!=k && nums[i][j]==list.get(k))ball_cnt++;
                }
            }
            if( strike_cnt!=strike[i] ||ball_cnt !=ball[i])return false;
        }
        return true;
        
    }
}
