import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []line=new String[2];
        line=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int K=Integer.parseInt(line[1]);
        ArrayList<Integer> nodes[]=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }
        for(int i=0;i<K;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0])-1;
            int b=Integer.parseInt(line[1])-1;
            nodes[a].add(b);
            nodes[b].add(a);
        }
        boolean visited[]=new boolean[N];
        int cnt=0;
        Queue<Integer> works=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            if(!visited[i]){
                cnt++;
                visited[i]=true;
                works.add(i);
                while(!works.isEmpty()){
                    int cur=works.poll();
                    for(int j=0;j<nodes[cur].size();j++){
                        int next=nodes[cur].get(j);
                        if(!visited[next]){
                            visited[next]=true;
                            works.add(next);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }   
}
