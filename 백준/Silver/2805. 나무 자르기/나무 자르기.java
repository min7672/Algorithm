import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Long> arr;
    static long result;
    static void findNumber(long start, long end, Long M){
        if(start>end)return;
        else{
            long mid=(end+start)/2;
            long total=0;
            for( long x: arr){
                if(x>mid)total+=(x-mid);
            }
            if(total>=M){
                result=mid;
                findNumber(mid+1, end,M);
                
            }else{
                findNumber(start, mid-1,M);
                
                
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        long M=Long.parseLong(info[1]);
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Long.parseLong(st.nextToken()));
        }
        arr.sort(null);
        
        result=0;
        findNumber(Long.valueOf(0),arr.get(N-1), M);
        System.out.println(result);
    }
}
