import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static ArrayList<Integer> nodes[];
    static int leafCnt;
    static int rmNode, start;
    static int parent[];
    static void dfs(int x){
        
        int nodeCnt=0;
        // System.out.println(x+" "+ nodes[x].toString());
        for(int i=0;i<nodes[x].size();i++){
            
            int next=nodes[x].get(i);   
            if(start!=next && rmNode!=next && parent[x]!=next){
                nodeCnt++;   
            }
            
            if(!visited[next] && start!=next && rmNode!=next){
                visited[next]=true;
                dfs(next);
                visited[next]=false;
            }
        }
        if(nodeCnt==0){
            // System.out.print(x+ " ");
            leafCnt++;
        }
        
        
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        start=0;
        parent=new int[N];
        for(int a=0;a<N;a++){
            int b=Integer.parseInt(st.nextToken());
            parent[a]=b;
            if(b!=-1){
                nodes[a].add(b);
                nodes[b].add(a);
            }else{
                start=a;
            }
        }
        rmNode=Integer.parseInt(br.readLine());
        nodes[rmNode].clear();
        visited=new boolean[N];
        if(start==rmNode)System.out.println("0");
        else{
            visited[start]=true;
            visited[rmNode]=true;
            dfs(start);
            System.out.println(leafCnt);
        }
        


        
    }
}