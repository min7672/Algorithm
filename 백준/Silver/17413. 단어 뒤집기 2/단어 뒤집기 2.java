import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack=new Stack<>();
        Queue<Character> queue=new ArrayDeque<>();
        char []words=br.readLine().toCharArray();

        boolean checker=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++){
            char word=words[i];
            
            if( word=='>'){
                checker=false;
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                }
                sb.append(word);
            }else if(word=='<' || checker){
                checker=true;
                queue.add(word);
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }else if(!checker && word==' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ") ;
            }else{
                stack.add(word);
            } 
            
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
