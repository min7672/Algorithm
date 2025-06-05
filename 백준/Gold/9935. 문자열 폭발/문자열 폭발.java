import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String text=br.readLine();           
        
        String comp=br.readLine();
        int compLen=comp.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<text.length();i++){
            sb.append(text.charAt(i));
            if(sb.length()>=compLen){
                boolean match=true;
                for(int j=0;j<compLen;j++){
                    if(sb.charAt(sb.length()-compLen+j)!=comp.charAt(j)){
                        match=false;
                        break;
                    }
                }
                if(match){
                    sb.setLength(sb.length()-compLen);
                }
            }
        }
        
          System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}