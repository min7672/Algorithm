import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static boolean visited[];
    static ArrayList<Integer> nodes[];
    static boolean check;

    static void dfs(int x, int depth){
        if(check)return;
        if(depth>=5){
            check=true;
            return ;
        }
        
        for(int i=0;i<nodes[x].size();i++){
            int next=nodes[x].get(i);
            if(!visited[next]){
                visited[next]=true;
                dfs(next, depth+1);
                visited[next]=false;
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=new String[2];
        line=br.readLine().split(" ");
        N=Integer.parseInt(line[0]);
        M=Integer.parseInt(line[1]);
        nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            nodes[a].add(b);
            nodes[b].add(a);
        }
        check=false;
        for(int i=0;i<N;i++){
            if(check)break;
            visited=new boolean[N];
            dfs(i, 0);
            
        }
        if(check)System.out.println(1);
        else System.out.println(0);
        

    }
}
