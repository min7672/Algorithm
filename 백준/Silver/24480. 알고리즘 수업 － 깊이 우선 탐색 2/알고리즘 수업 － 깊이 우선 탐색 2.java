import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;



public class Main {
    static int N,M,R;
    static boolean visited[];
    static ArrayList<Integer> arr[];
    static int result[];
    static int cnt;
    static void dfs(int x){
        result[x]=cnt++;

        for(int i=0;i<arr[x].size();i++){
            int next=arr[x].get(i);
            if(!visited[next]){
                visited[next]=true;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] line=new String[3];
        line=br.readLine().split(" ");
        N=Integer.parseInt(line[0]);
        M=Integer.parseInt(line[1]);
        R=Integer.parseInt(line[2])-1;
        arr=new ArrayList[N];
        
        for(int i=0;i<N;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0])-1;
            int b=Integer.parseInt(line[1])-1;
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=0;i<N;i++){
            arr[i].sort(Comparator.reverseOrder());;
        }
        result=new int[N];
        visited=new boolean[N];
        visited[R]=true;
        cnt=1;
        dfs(R);
        for(int i=0;i<N;i++){
            System.out.println(result[i]);
        }
    }   
}
