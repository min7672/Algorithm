import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    static int N, M,V;
    static ArrayList<Integer> nodes[];
    static boolean visited[];
    static int result[];
    static int result2[];
    
    static class Node{
        public int x;
        public int depth;
        Node(int x,int depth){
            this.x=x;
            this.depth=depth;
        }
    }
    static void bfs(int a){
        visited=new boolean[N];
        Queue<Node> works= new ArrayDeque<>();
        visited[a]=true;
        result[a]=0;
        int cnt=1;
        
        works.add(new Node(a, 0));
        while(!works.isEmpty()){
            Node cur=works.poll();
            result2[cur.x]=cnt++;    
            for(int i=0;i<nodes[cur.x].size();i++){
                int next=nodes[cur.x].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    result[next]=cur.depth+1;
                    works.add(new Node(next, cur.depth+1));
                }
            }
        }
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String info[]=sc.nextLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        V=Integer.parseInt(info[2])-1;
        visited=new boolean[N];
        nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            info=sc.nextLine().split(" ");
            int a=Integer.parseInt(info[0])-1;
            int b=Integer.parseInt(info[1])-1;
            nodes[a].add(b);
            nodes[b].add(a);
        }
        for(int i=0;i<N;i++){
            nodes[i].sort(null);
        }
        
        result=new int[N];
        result2=new int[N];
        for(int i=0;i<N;i++){
            result[i]=-1;
        }
        bfs(V);
        BigInteger sum = BigInteger.ZERO;
        
        for (int i = 0; i < N; i++) {
            
            BigInteger tmp = BigInteger.valueOf(result[i]).multiply(BigInteger.valueOf(result2[i]));
            sum = sum.add(tmp);
        }
        
        System.out.println(sum);
        
    }
}
