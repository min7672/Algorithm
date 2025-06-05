import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();
        int N=arr.length();
        
        int cnt=0;
        for(int i=1;i<=N;i++){/*window size */
            ArrayList<String> curList=new ArrayList<>();
            for(int j=0;j<=N-i;j++){
                String tmp=arr.substring(j,j+i );
                
                if( !curList.contains(tmp)){
                    cnt++;
                    curList.add(tmp);
                }
                
            }
            
            
        }
        
        System.out.println(cnt);

    }
}
