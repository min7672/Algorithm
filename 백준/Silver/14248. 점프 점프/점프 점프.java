import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static boolean visited[];
    static void dfs(int x, int arr[]){
        
        int pre= x-arr[x];
        int next= x+arr[x];
        if(pre>=0 &&!visited[pre]){
            result++;
            visited[pre]=true;
            dfs(pre, arr);
        }
        if(next<arr.length && !visited[next]){
            result++;
            visited[next]=true;
            dfs(next, arr );
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            
            arr[i]=Integer.parseInt(st.nextToken());
        }
        result=1;
        int S= Integer.parseInt(br.readLine());
        visited=new boolean[N];
        dfs(S-1, arr);
        System.out.println(result);
    }   
}
