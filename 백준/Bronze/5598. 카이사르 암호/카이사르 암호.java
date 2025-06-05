import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        char arr[]=br.readLine().toCharArray();
        String result="";
        for(int i=0;i<arr.length;i++){
            int tmp=((int)arr[i]- (int)'A'+26-3 )%26+(int)'A';
            
            result+=(char)tmp;

        }
        System.out.println(result);
    }
}
