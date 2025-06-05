import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M,V;
    static ArrayList<Integer> nodes[];
    static boolean visited[];
    static int result[];
    
       static void bfs(int a){
        visited=new boolean[N];
        Queue<Integer> works= new ArrayDeque<>();
        visited[a]=true;
        int cnt=1;
        works.add(a);
        while(!works.isEmpty()){
            int cur=works.poll();
            result[cur]=cnt++;
            for(int i=0;i<nodes[cur].size();i++){
                int next=nodes[cur].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    works.add(next);
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
        bfs(V);
        
        for(int i=0;i<N;i++){
            System.out.println(result[i]);
        }
    }
}