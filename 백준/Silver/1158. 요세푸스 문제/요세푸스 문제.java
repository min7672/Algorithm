import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main { 
    static List<Integer> arr;
    static int result[];
    static int N,K;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           String info[]=br.readLine().split(" ");
           N=Integer.parseInt(info[0]);
           K=Integer.parseInt(info[1]);
           
           br.close();

           init();
           run();

           bw.flush();
           bw.close();
           
    }
    static void init(){
        arr=new ArrayList<>();
        result=new int[N];
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=N;i++){
            arr.add(i);
        }
    }
    static void run() throws IOException{
        int idx=0;
        int _idx=idx;
        int length=N;
        bw.write("<");
        for(int cnt=0;cnt<N;cnt++){
            _idx=(_idx+K-1)%length;
                
            result[cnt]=arr.get(_idx);
            bw.write(arr.remove(_idx) + (arr.isEmpty() ? ">" : ", "));
            length--;
        }
    }
}