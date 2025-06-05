import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean visited[];
    static StringBuilder sb;
    static ArrayList<Integer> arr;
    static void combi(int idx,int depth) throws IOException {
        if(depth==M){
            for(int i=0;i<N;i++){
                              
                if(visited[i]){ 
                    System.out.print(arr.get(i)+" ");
                    
                }
            }
            System.out.println("");
            return;
        }
        if(idx==N)return;
        
        visited[idx]=true;
        combi(idx+1, depth+1);
        visited[idx]=false;
        combi(idx+1, depth);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        visited=new boolean[N];
        sb=new StringBuilder();
        arr.sort(null);
        combi(0, 0);
        

    }
}
