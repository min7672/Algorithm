import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean visited[];
    static BufferedWriter bw;
    static StringBuilder sb;
    /*
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * 고른 수열은 오름차순이어야 한다.
 
     */
    public static void main(String[] args) throws IOException{
        init();
        solve();
    }
    static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input[]=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        br.close();
        visited=new boolean[N];
        sb=new StringBuilder();
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    static void solve() throws IOException{
        combi(0, 0);
        bw.flush();
        bw.close();
    }
    static void combi(int idx, int depth)throws IOException{
        //종료 조건
        if(depth==M){
            bw.write(sb.toString());
            bw.newLine();
            return;
        }
        if(idx==N){
            return;
        }

        for(int i=idx;i<N;i++){
            if(visited[i])continue;
            sb.append(i+1).append(" ");
            visited[i]=true;
            combi(i+1, depth+1);
            visited[i]=false;
            sb.delete(sb.length()-2, sb.length());
        }
    }
}
