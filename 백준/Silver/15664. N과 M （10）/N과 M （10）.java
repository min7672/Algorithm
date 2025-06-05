import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main {
        static int arr[];
        static ArrayList<Integer> node;
        static int N;
        static int M;
        static boolean visited[];
        static ArrayList<Integer> result;
    static void permu(int idx,int start,BufferedWriter bw)throws IOException{
        
        if(idx==M){
            bw.write(result.toString().replaceAll(",", "").replace("[", "").replace("]", "")+"\n");
            return;
        }
        for(int i=start;i<node.size();i++){
            int tmp=node.get(i);
            if(arr[tmp]>0){
                result.add(tmp);
                arr[tmp]-=1;
            }else{
                continue;
            }
            permu(idx+1, i, bw);
            result.remove(result.size()-1);
            arr[tmp]+=1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String info[]=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[10001];
        node=new ArrayList<>();
        for(int i=0;i<N; i++){
            int tmp=Integer.parseInt(st.nextToken());
            if(arr[tmp]==0){
                node.add(tmp);
            }
            arr[tmp]+=1;


        }
        node.sort(null);
        result=new ArrayList<>();
        visited=new boolean[N];
        permu(0,0,bw);
        bw.flush();
    }

}
