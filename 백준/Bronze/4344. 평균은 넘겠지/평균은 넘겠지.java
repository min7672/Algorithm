import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer("");
        for(int test_case=0;test_case<T;test_case++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int arr[]=new int[num];
            int sum=0;
            for(int i=0;i<num;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            float mean=sum/(float)num;
            int result=0;
            for(int i=0;i<num;i++){
                if(arr[i]>mean)result++;
            }
             System.out.println(String.format("%.3f",result/(float)num*100)+"%");
            
        }
    }
    
}
