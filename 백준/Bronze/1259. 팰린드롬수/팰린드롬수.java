import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean checker(char []word){
        int len=word.length;
        for(int i=0;i<Math.floor(len/2);i++){
            if(word[i]!=word[len-i-1]){
                return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            char[] line=br.readLine().toCharArray();
            if(line.length==1 && line[0]=='0')break;
            
            if(checker(line))System.out.println("yes");
            else System.out.println("no");

        }

        
    }
}