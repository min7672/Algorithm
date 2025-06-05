import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static boolean visited[];
    static StringBuilder sb;
    static void permu(int idx){
        if(idx==M){
            System.out.println(sb);
            return;
        }
        
        
        for(int i=0;i<N;i++){
            if(visited[i])continue;
            visited[i]=true;
            sb.append((i+1)+" ");

            permu(idx+1);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        visited=new boolean[N];
        sb=new StringBuilder();
        permu(0);

    }
}
