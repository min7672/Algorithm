import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer> node[];
    static int N, M, V;
    static boolean visited[];
    static void dfs(int x, StringBuilder sb){
        sb.append(x).append(" ");
        
        for(int i=0;i<node[x].size();i++){
            
            int next=node[x].get(i);

            if(!visited[next]){
                visited[next]=true;
                dfs(next,sb);
                

            }
        }
        
    }
    
    public static void main(String []args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());
        node=new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=0;i<=N;i++){
            node[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        for(int i=0;i<=N;i++){
            node[i].sort(null);
        }
        
        visited[V]=true;
        
        dfs(V,sb);
        sb.deleteCharAt(sb.length()-1);
                
        System.out.println(sb.toString());
        sb.setLength(0);

        Queue<Integer> queue= new ArrayDeque<>();
        visited=new boolean[N+1];
        queue.add(V);
        visited[V]=true;
        sb.append(V).append(" ");
        while (!queue.isEmpty()) {
            int cur=queue.poll();
            for(int i=0;i<node[cur].size();i++){
                int next=node[cur].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(next);
                    sb.append(next).append(" ");
                    
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        
    }
}