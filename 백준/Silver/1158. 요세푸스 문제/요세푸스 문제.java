import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { 
    static int arr[];
    static boolean used[];
    static int result[];

    public static void main(String[] args) throws IOException{
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           String info[]=br.readLine().split(" ");
           int N=Integer.parseInt(info[0]);
           int K=Integer.parseInt(info[1]);
           
            br.close();

           init(N);
           run(N, K);

           BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
           
           bw.write("<");
           for(int i=0;i<N-1;i++){
                bw.write(result[i]+", ");
           }
           bw.write(result[N-1]+">");

           bw.flush();
           bw.close();
           
    }
    static void init(int n){
        arr=new int[n];
        result=new int[n];
        used=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
    }
    static void run(int n,int k){
        int idx=0;
        int _idx=idx;
        int k_cnt=k;
        for(int cnt=0;cnt<n;cnt++){
            while(k_cnt!=0){
                _idx=(_idx)%n;
                
                //사용한거 pass
                if(used[_idx]){
                    _idx++;
                    continue;
                }
                
                k_cnt--;

                if(k_cnt==0){
                    result[cnt]=arr[_idx];
                    used[_idx]=true;
                    
                }

                _idx++;
            }
            k_cnt=k;
        }

    }
}