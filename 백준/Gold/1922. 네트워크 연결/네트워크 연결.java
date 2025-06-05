import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    static class Edge{
        public int from;
        public int to;
        public int weight;
        Edge(int from,int to, int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }
    }
    static void make(int parents[], int N){
        
        for(int i=0;i<N;i++){
            parents[i]=i;
        }
    }
    static int find(int a, int parents[]){
        if(a==parents[a])return a;
        return parents[a]=find(parents[a], parents);
    }
    static boolean union(int a, int b, int parents[]){
        int aRoot=find(a,parents);
        int bRoot=find(b,parents);
        if(aRoot==bRoot){
            return false;
        }else{
            parents[bRoot]=aRoot;
            return true;
        }
        
        

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        String line[]=new String[3];
        
        ArrayList<Edge> edges=new ArrayList<>();
        int []parents=new int[N];
        make(parents, N);

        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0])-1;
            int b=Integer.parseInt(line[1])-1;
            int c=Integer.parseInt(line[2]);
            edges.add(new Edge(a, b, c));
            
        }
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        boolean visited[]=new boolean[N];
        int sum=0;
        for(int i=0;i<M;i++){
            Edge cur=edges.get(i);
            
            
            boolean check=union(cur.from, cur.to, parents);
            
            if(check){
                visited[cur.from]=true;
                visited[cur.to]=true;
                sum+=cur.weight;
            }
        }
        
        System.out.println(sum);
        
        
    }
}
