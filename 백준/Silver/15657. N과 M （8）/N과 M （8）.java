import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main {
        static ArrayList<Integer> arr;
        static int N;
        static int M;
        static ArrayList<Integer> result;
    static void permu(int idx,int start,BufferedWriter bw)throws IOException{
        
        if(idx==M){
            bw.write(result.toString().replaceAll(",", "").replace("[", "").replace("]", "")+"\n");
            return;
        }
        for(int i=start;i<N;i++){
            result.add(arr.get(i));
            permu(idx+1,i, bw);
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
        arr=new ArrayList<>();
        for(int i=0;i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(null);;
        result=new ArrayList<>();
        permu(0,0,bw);
        bw.flush();
    }

}