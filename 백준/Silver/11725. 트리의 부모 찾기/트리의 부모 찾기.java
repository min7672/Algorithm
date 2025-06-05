import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        int nodeB[]=new int[N];
        String []line=new String[2];
        ArrayList<Integer> nodes[]=new ArrayList[N];
        int nodeCnt[]=new int[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
            
        }
        for(int i=0;i<N-1;i++){
            line=sc.nextLine().split(" ");
            int a= Integer.parseInt(line[0])-1;
            int b=Integer.parseInt(line[1])-1;
            
            
            nodes[a].add(b);
            nodes[b].add(a);
        }
        Queue<Integer> works=new LinkedList<>();
        
        boolean visitied[]=new boolean[N];
        works.add(0);
        visitied[0]=true;
        while (!works.isEmpty()) {
            int cur=works.poll();

            for(int i=0;i<nodes[cur].size();i++){
                int next=nodes[cur].get(i);
                nodeCnt[next]--;
                if(!visitied[next]){
                    works.add(next);
                    visitied[next]=true;
                    
                    nodeB[next]=cur;
                }
            }
        }
        for(int i=1;i<N;i++){
            System.out.println(nodeB[i]+1);
        }
        
    }
}
