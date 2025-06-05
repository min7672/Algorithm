import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static int N, M;
    static int ins_depth;
    static ArrayList<Integer> nodesF[];
    static ArrayList<Integer> nodesB[];
    static boolean visited[];
    static void dfs(int x, int dir){
        if(dir==0){

            for(int i=0;i<nodesF[x].size();i++){
                int next=nodesF[x].get(i);
                if(visited[next])continue;
                visited[next]=true;
                ins_depth++;
                dfs(next, dir);
            }
        }else{
            for(int i=0;i<nodesB[x].size();i++){
                int next=nodesB[x].get(i);
                if(visited[next])continue;
                visited[next]=true;
                ins_depth++;
                dfs(next, dir);
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            nodesF=new ArrayList[N];
            nodesB=new ArrayList[N];
            for(int i=0;i<N;i++){
                nodesF[i]=new ArrayList<>();
                nodesB[i]=new ArrayList<>();
            }
            String line[]=new String[2];

            for(int i=0;i<M;i++){
                line=br.readLine().split(" ");
                int a=Integer.parseInt(line[0])-1;
                int b=Integer.parseInt(line[1])-1;
                nodesF[a].add(b);
                nodesB[b].add(a);
            }
            int result=0;
            for(int i=0;i<N;i++){
                visited=new boolean[N];
                visited[i]=true;
                ins_depth=1;

                dfs(i,0 );

                dfs(i,1 );
                if( ins_depth==N)result++;
            }
            System.out.printf("#%d %d\n", test_case,result);
        }
    }
}