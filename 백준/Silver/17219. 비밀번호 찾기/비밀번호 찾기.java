import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String line[]=new String[2];

        line=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        HashMap<String, String> pwList=new HashMap<>();
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            pwList.put(line[0], line[1]);
        }
        
        for(int i=0;i<M;i++){

            bw.write(pwList.get(br.readLine())+"\n");
        }
        bw.flush();
    }   
}
