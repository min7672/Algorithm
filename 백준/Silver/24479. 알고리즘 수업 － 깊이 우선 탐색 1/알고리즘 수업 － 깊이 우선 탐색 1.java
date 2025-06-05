import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static boolean visitied[];
    static int N,M,R;
    static ArrayList<Integer> nodes[];
    static int visitOrder[];
    static int cnt;

    static void dfs(int cur){
        visitOrder[cur]=cnt++;
        visitied[cur]=true;
        for(int i=0;i<nodes[cur].size();i++){
            int next= nodes[cur].get(i);
            if (!visitied[next]) {
                
                dfs(next);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        R=Integer.parseInt(info[2])-1;
        nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            info=br.readLine().split(" ");
            int a=Integer.parseInt(info[0])-1;
            int b=Integer.parseInt(info[1])-1;
            nodes[a].add(b);
            nodes[b].add(a);
        }
        for(int i=0;i<N;i++){
            nodes[i].sort(null);
        }

        visitied=new boolean[N];
        
        visitOrder=new int[N];
        cnt=1;
        
        dfs(R);
        for(int i=0;i<N;i++){
            System.out.println(visitOrder[i]);
        }
        


        
    }
}
