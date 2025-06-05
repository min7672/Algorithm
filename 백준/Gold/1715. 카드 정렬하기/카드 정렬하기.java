import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt=pq.size();
        int sum=0;
        while(cnt>=2){
            int a=pq.poll();
            int b=pq.poll();
            pq.add(a+b);
            sum+=a+b;
            cnt--;
        }
        System.out.println(sum);
        
    }
}