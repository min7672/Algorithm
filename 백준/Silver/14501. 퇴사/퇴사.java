import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int dp[]=new int[N+2];
        StringTokenizer st=null;

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            int t= Integer.parseInt(st.nextToken());
            int p= Integer.parseInt(st.nextToken());
            dp[i]=Math.max(dp[i], dp[i-1]);
            
            if(i+t<=N+1){
                
                dp[i+t]=Math.max(dp[i]+p, dp[i+t]);
            }
        }

        int max = 0;
		for (int i = 1; i <= N+1; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
    }

}