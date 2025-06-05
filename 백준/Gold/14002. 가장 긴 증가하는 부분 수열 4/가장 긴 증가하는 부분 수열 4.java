import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int arr[]=new int[N];
        ArrayList<Integer> index[]=new ArrayList[N];
        for(int i=0;i<N;i++){
            index[i]=new ArrayList<Integer>();
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int count[]=new int[N];
        
        for(int i=0;i<N;i++){
            count[i]=1;
            
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(count[i] <count[j]+1){
                        count[i]=count[j]+1;
                        index[i] = new ArrayList<>(index[j]);
                    }
                }
                
            }
            index[i].add(i);
            
            
        }
        int max_cnt=0;
        for(int i=0;i<N;i++){
            if(count[max_cnt]<count[i])max_cnt=i;
            
        }
        
        System.out.println(index[max_cnt].size());
        for(int i=0;i<index[max_cnt].size();i++){
            System.out.print(arr[index[max_cnt].get(i)]+" ");
        }
        
        
    }
}