import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[][];
    static int N;
    static boolean visited[];
    static int result;
    static void combi(int idx, int depth){
        if(depth>0){
            /*계산 */
            int sintTaste=1;
            int ssonTaste=0;
            for(int i=0;i<N;i++){
                if(visited[i]){
                    sintTaste*=arr[i][0];
                    ssonTaste+=arr[i][1];
                }
            }
            result=Math.min(result,(int)Math.abs(sintTaste-ssonTaste));

        }


        if(idx==N)return; 

        visited[idx]=true;
        combi(idx+1 , depth+1);
        visited[idx]=false;
        combi(idx+1 , depth);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int [N][2];
        String []info=new String[2];
        for(int i=0;i<N; i++){
            info=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(info[0]); /* 신맛 */
            arr[i][1]=Integer.parseInt(info[1]);  /*쓴맛 */
        }
        visited=new boolean[N];
        result=Integer.MAX_VALUE;
        combi(0,0);
        System.out.println(result);
        
    }
}
