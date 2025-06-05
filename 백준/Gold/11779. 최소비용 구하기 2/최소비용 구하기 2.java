import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        public int to;
        public int cost;
        public String path;
        Node(int to, int cost, String path){
            this.to=to;
            this.cost=cost;
            this.path=path;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        ArrayList<Node> nodes[]=new ArrayList[N+1];
        int cost[]=new int[N+1];
        String pathes[]=new String[N+1];
        for(int i=0;i<=N;i++){
            nodes[i]=new ArrayList<>();
            cost[i]=Integer.MAX_VALUE;
        }
        StringTokenizer st=null;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c, b+" "));
        }
        
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        PriorityQueue<Node> works=new PriorityQueue<>();

        works.add(new Node(start, 0, start+" "));
        cost[start]=0;
        pathes[start]=start+" ";
        while (!works.isEmpty()) {
            Node cur=works.poll();
            if (cur.cost > cost[cur.to]) continue;

            for(int i=0;i<nodes[cur.to].size();i++){
                Node next=nodes[cur.to].get(i);
                int newCost = cost[cur.to] + next.cost;
                if(cost[cur.to]+next.cost<cost[next.to]){
                    cost[next.to] = newCost;
                    pathes[next.to] = pathes[cur.to] + next.to + " ";
                    works.add(new Node(next.to, newCost,""));
                }
            }
        }
        System.out.println(cost[end]);
        String []result=pathes[end].split(" ");
        System.out.println(result.length);
        System.out.println(pathes[end]);
        //System.out.println( Arrays.toString(pathes));
    }
}