import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            if( a==0){
                int len=heap.size();
                if(len==0){
                    System.out.println(0);
                }else{
                    int value=heap.poll();
                    System.out.println(value);
                }
            }else{
                heap.add(a);
                
            }
            
        }
    }
}