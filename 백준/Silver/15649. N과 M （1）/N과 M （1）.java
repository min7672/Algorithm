import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    static int N;
    static int M;
    static boolean[] visited;
    static StringBuilder sb;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        init();
        solve();
    }
    static void init() throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input[]=new String[2];
        input=br.readLine().split(" ");
        br.close();
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        visited=new boolean[N];
        sb=new StringBuilder();
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    static void solve()throws IOException{
        permu(0);
        bw.flush();
        bw.close();
    }
    static void permu(int idx)throws IOException{
        //종료조건
        if(idx==M){
            bw.write(sb.toString());
            bw.newLine();
            return;
        }
        for(int i=0;i<N;i++){
            if(visited[i])continue;
            visited[i]=true;
            sb.append(i+1).append(" ");
            permu(idx+1);
            visited[i]=false;
            sb.delete(sb.length()-2, sb.length());
        }

    }
}
