import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean solution(int arr[], int L){
        int N=arr.length;
        boolean result=true;
        boolean used[]=new boolean[N];
        int cnt=0;
        int k=0;
        
        for(int i=0;i<N;i++){
            //좌 L만큼 이동 
            
            k=i-1;
            
            if(k>=0 && arr[i]-1==arr[k]){
                
                cnt=0;
                int z=k;
                for(;z>k-L;z--){
                    if(z<0)break;
                    
                    if(arr[k]!=arr[z])break;
                    
                    if(used[z])break;
                    used[z]=true;
                    cnt++;
                    if(cnt==L)break;
                }
                
                if(cnt!=L )return result=false;

            }else if(k>=0 && arr[i]-1>arr[k])   {
                
                return result=false;
            }

            k=i+1;
            if(k<N && arr[i]-1==arr[k]){
                

                cnt=0;
                int z=k;
                for(;z<k+L;z++){
                    if(z>=N)break;
                    if(arr[k]!=arr[z])break;
                    if(used[z])break;
                    used[z]=true;
                    cnt++;
                    if(cnt==L)break;
                }
                
                if(cnt!=L)return result=false;
                // System.out.println(i+ " "+Arrays.toString(used));
            }else if(k<N && arr[i]-1>arr[k])   {
                return result=false;
            }
            
        }
        
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
            StringTokenizer st=new StringTokenizer(br.readLine());

            int N=Integer.parseInt(st.nextToken());
            int L=Integer.parseInt(st.nextToken());
            int arr[][]=new int[N][N];
            int arr2[][]=new int[N][N];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    
                }
                for(int j=0;j<N;j++){
                    arr2[j][i]=arr[i][j];
                    
                }
                
            }
            int cnt=0;
            // for(int i=0;i<N;i++){
            //     if(solution(arr[i],L))cnt++;
                
            //     System.out.println(i+", "+solution(arr[i],L) +" " + Arrays.toString(arr[i]));
            // }
            for(int i=0;i<N;i++){
                if(solution(arr[i],L))cnt++;
                if(solution(arr2[i],L))cnt++;
                // System.out.println(i+", "+solution(arr2[i],L) +" " + Arrays.toString(arr2[i]));
            }
            System.out.printf("%d\n",  cnt);
        
    }
}
