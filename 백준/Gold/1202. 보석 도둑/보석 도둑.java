import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Jewel{
        public int w;
        public int v;
        Jewel(int w,int v){
            this.w=w;
            this.v=v;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=new String[2];
        line=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int K=Integer.parseInt(line[1]);
        List<Jewel> jewels=new ArrayList<>();
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            int w=Integer.parseInt(line[0]);
            int v=Integer.parseInt(line[1]);
            jewels.add(new Jewel(w, v));
        }
        /*nlogn */
        jewels.sort( new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2){
                if(o1.w-o2.w==0){
                    return o2.v-o1.v;
                }else return o1.w-o2.w;
            }
        } );
        List<Integer> cPQ=new ArrayList<>();
        for(int i=0;i<K;i++){
            cPQ.add(Integer.parseInt(br.readLine()));
        }
        cPQ.sort(null);
        

        /* n^2   300,000^2 */
        int idx=0;
        long sum=0;
        PriorityQueue<Integer> values=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<K;i++){
            int C=cPQ.get(i);
            
            while(idx<N){
                // System.out.println(">>> "+idx);
                Jewel cur=jewels.get(idx);
                
                if(cur.w<=C){
                    idx++;
                    
                    values.add(cur.v);
                }else{
                    break;
                }
            }
            if (!values.isEmpty()) {
                sum += values.poll();
            }

        }
        
        System.out.println(sum);
        
    }   
}
/*

 */