import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        HashSet<String> set=new HashSet<String>();
        
        
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        List<String> list=Arrays.asList(set.toArray(new String[0]));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                int result=o1.length()-o2.length();
                if(result==0){
                    result=o1.compareTo(o2);
                }
                return result;
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
