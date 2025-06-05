import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String[] line=new String[2];
        HashSet<String> person= new HashSet<>();
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            if(line[1].equals("enter")){
                person.add(line[0]);
            }else{
                person.remove(line[0]);
            }
        }
        List<String> list=Arrays.asList( person.toArray(new String[0]));
        list.sort(Comparator.reverseOrder());        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }    
}
