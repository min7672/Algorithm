import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        static int arr[];
        static int N;
        static int M;
        static ArrayList<Integer> result;
    static void permu(int idx,BufferedWriter bw)throws IOException{
        
        if(idx==M){
            bw.write(result.toString().replaceAll(",", "").replace("[", "").replace("]", "")+"\n");
            return;
        }
        for(int i=0;i<N;i++){
            result.add(arr[i]);
            permu(idx+1, bw);
            result.remove(result.size()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result=new ArrayList<>();
        permu(0,bw);
        bw.flush();
    }

}