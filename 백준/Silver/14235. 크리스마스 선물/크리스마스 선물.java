import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        ArrayList<Integer> gift = new ArrayList<>();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            if( a==0){
                int len=gift.size();
                if(len==0){
                    System.out.println(-1);
                }else{
                    int value=gift.get(len-1);
                    gift.remove(len-1);
                    System.out.println(value);
                }
            }else{
                for(int j=0;j<a;j++){
                    gift.add(Integer.parseInt(st.nextToken()));
                }
                gift.sort(Comparator.naturalOrder());
            }
            
        }
    }
}