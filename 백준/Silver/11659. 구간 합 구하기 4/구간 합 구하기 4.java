import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int base[];

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        base=new int[N];
        
        
        String arr[]=br.readLine().split(" ");
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=Integer.parseInt(arr[i]);
            base[i]=sum;
        }
        String tmp[]=new String[2];
        int minusIdx=0;
        int sub=0;
        for(int i=0;i<M;i++){
            tmp=br.readLine().split(" ");
            minusIdx=Integer.parseInt(tmp[0])-2;
            sub=0;
            if(minusIdx>=0)sub=base[minusIdx];
            System.out.println(base[Integer.parseInt(tmp[1])-1]-sub);
        }
        
    }
}