import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int result=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N; j++){
                if(j==i )continue;
                for( int k=0;k<N; k++){
                    if(i==k || j==k )continue;
                    int sum=arr[i]+arr[j]+arr[k];
                    if( sum <=M&& M-sum<M-result){
                        result=sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}