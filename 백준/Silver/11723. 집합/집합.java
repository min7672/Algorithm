import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[21];
        boolean[] arrAll=new boolean[21];
        boolean visit[]=new boolean[21];

        for(int i=1;i<=20;i++){
            arr[i]=i;
            arrAll[i]=true;
        }
        
        StringTokenizer st=null;
        for(int j=0;j<N;j++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            if(command.equals("all")){
                visit=arrAll.clone();
                continue;
            }
            if(command.equals("empty")){
                visit=new boolean[21];
                continue;
            }
            int num=Integer.parseInt(st.nextToken());
            if(command.equals("add")){
                visit[num]=true;
            }
            if(command.equals("remove")){
                visit[num]=false;
            }
            if(command.equals("check")){
                if(visit[num])bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            if(command.equals("toggle")){
                visit[num]=!visit[num];
            }
            

        }
        bw.flush();
    }
}