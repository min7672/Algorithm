import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String result="";
        while (true) {
            String text=br.readLine();
            if(text.length()==1 && text.equals("."))break;
            Stack<Character> stack = new Stack<>();
            char []line=text.toCharArray();

            result="yes";

            for(int i=0;i<line.length;i++){
                if(line[i]=='[' || line[i]=='('){
                    stack.add(line[i]);
                }

                if(line[i]==']'){
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    }else{
                        result="no";
                        break;
                    }
                }
                if(line[i]==')'){
                    if(!stack.isEmpty() &&stack.peek()=='('){
                        
                        stack.pop();
                    }else{
                        result="no";
                        
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                result="no";
            }
            System.out.println(result);
        }
        
    }
}
