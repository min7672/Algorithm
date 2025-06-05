import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Info{
        public int x;
        public int depth;
        Info(int x, int depth){
            this.x=x;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        int K=Integer.parseInt(info[2]);
        int X=Integer.parseInt(info[3])-1;
        ArrayList<Integer> nodes[]=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        String line[]=new String[2];
        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            nodes[Integer.parseInt(line[0])-1].add(Integer.parseInt(line[1])-1);
        }
        Queue<Info> works=new LinkedList();
        boolean visited[]=new boolean[N];
        visited[X]=true;
        works.add(new Info(X,0));
        ArrayList<Integer> result=new ArrayList<>();
        while(!works.isEmpty()){
            Info cur=works.poll();
            
            for(int i=0;i<nodes[cur.x].size();i++){
                int next=nodes[cur.x].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    
                    works.add(new Info(next, cur.depth+1));
                    if(cur.depth+1==K){
                        result.add(next);
                        
                    }

                }
            }
        }
        
        if(result.size()==0){
            System.out.println("-1");
        }else{
            result.sort(null);
            for(int i=0;i<result.size();i++){
                System.out.println(result.get(i)+1);
            }
        }

        
        
    }
}
