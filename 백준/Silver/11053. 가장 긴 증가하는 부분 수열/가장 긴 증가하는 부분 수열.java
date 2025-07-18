import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int count[]=new int[N];
        
        for(int i=0;i<N;i++){
            count[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
            
        }
        int max_cnt=0;
        for(int i=0;i<N;i++){
            if(max_cnt<count[i])max_cnt=count[i];
        }
        System.out.println(max_cnt);
        
        
    }
}