import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        PriorityQueue<Long> card= new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            
            card.add(Long.parseLong(st.nextToken()));
        }
        for(int i=0;i<M;i++){
            long a=card.poll();
            long b=card.poll();
            
            long c= a+b;
            card.add(c);
            card.add(c);
        }
        long sum=0;
        while(!card.isEmpty()){
            sum+=card.poll();
        }
        System.out.println(sum);
    
    }
}
