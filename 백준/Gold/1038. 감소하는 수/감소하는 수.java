import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean visited[];
    static List<Long> list;

    public static void main(String[] args) throws IOException{
        init();
        solve();
    }
    static void init()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        br.close();
        list=new ArrayList<Long>();
    }
    static void solve(){
        for(int i=0;i<10;i++){
            declineNum(i,i);
        }
        list.sort(null);
        if(N>=list.size())System.out.println(-1);
        else System.out.println(list.get(N));
    }   
    static void declineNum(long num, int lastDigit){
        list.add(num);
        for(int i=0;i<lastDigit;i++){
            declineNum(num*10+i, i);            
        }
    }
}
