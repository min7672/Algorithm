import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    static int N;
    static int M;
    
    static StringBuilder sb;
    static void permu(int idx, BufferedWriter bw) throws IOException{
        if(idx==M){
            bw.write(sb.toString()+"\n");
            return;
        }
        
        for(int i=0;i<N;i++){
            sb.append((i+1)+" ");
            permu(idx+1,bw);
            sb.delete(sb.length() - 2, sb.length()); 
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        sb=new StringBuilder();
        
        permu(0,bw);
        bw.flush();

    }
}
