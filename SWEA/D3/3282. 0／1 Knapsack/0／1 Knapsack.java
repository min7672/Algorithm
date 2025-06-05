import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            String line[]=new String[2];
        
            line=br.readLine().split(" ");
            int N=Integer.parseInt(line[0]);
            int K=Integer.parseInt(line[1]);
            int dp[]=new int[K+1];
            for(int i=0;i<N;i++){
                line=br.readLine().split(" ");
                int w=Integer.parseInt(line[0]);
                int v=Integer.parseInt(line[1]);
                for(int j=K;j>=w;j--){
                    dp[j]= Math.max(dp[j], dp[j-w]+v);
                }
            }
            
            System.out.printf("#%d %d\n",test_case,dp[K]);
        }
        
    }
}