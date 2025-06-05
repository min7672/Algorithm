import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static boolean visited[];
    
    static void combi(int idx,int depth){
        if(depth==M){
            for(int i=1;i<=N;i++){
                              
                if(visited[i]){ 
                    System.out.print(i+" ");
                    
                }
            }
            System.out.println("");
            return;
        }
        if(idx==N+1)return;
        
        visited[idx]=true;
        combi(idx+1, depth+1);
        visited[idx]=false;
        combi(idx+1, depth);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        visited=new boolean[N+1];
        
        combi(1,0);

    }
}
