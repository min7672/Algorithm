import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<Point> nodes[];
    static class Point implements Comparable<Point>{
        public int to;
        public int cost;
        Point(int to, int cost){
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Point o) {
            return this.cost-o.cost;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String line[]=new String[3];
        line=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        int X=Integer.parseInt(line[2]);
        
        nodes=new ArrayList[N+1];
        
        for(int i=0;i<=N;i++){
            nodes[i]=new ArrayList<Point>();
            
        }

        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            int c=Integer.parseInt(line[2]);
            nodes[a].add(new Point(b, c));
            
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            int a=distance(i,X,N);
            int b=distance(X,i,N);
            result=Integer.max(a+b, result);
        }
        System.out.println(result);
        
        
    }
    public static int distance(int start,int end,int N){
        int dp[]=new int[N+1];
        for(int i=0;i<=N;i++){    
            dp[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Point> works=new PriorityQueue<>();
        works.add(new Point(start,0));
        dp[start]=0;
        while(!works.isEmpty()){
            Point cur=works.poll();
            
            
            for(int i=0;i< nodes[cur.to].size();i++){
                Point next=nodes[cur.to].get(i);
                int newCost = dp[cur.to] + next.cost;
                
                if(dp[next.to] > newCost){
                    dp[next.to]=Math.min(dp[next.to], newCost);
                    works.add(new Point(next.to, newCost));
                }
            }
        }
        return dp[end];
    }

    
}