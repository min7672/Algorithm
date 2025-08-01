import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []info=br.readLine().split(" ");
        
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);

        Map<String, Boolean> dic=new HashMap<>();
        List<String> result=new ArrayList<>();

        for(int i=0;i<N;i++){
            dic.put(br.readLine(), true);
        }
        for(int i=0;i<M;i++){
            String text=br.readLine();
            if(dic.containsKey(text)){
                result.add(text);
            }
        }
        result.sort(null);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
