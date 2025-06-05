import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String []line=new String[2];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N; i++){
            line=br.readLine().split(" ");
            if( line[0].equals("push")){
                stack.add(Integer.parseInt(line[1]));
            }else if( line[0].equals("pop")){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }else{
                    System.out.println(-1);
                }
            }else if( line[0].equals("top")){
                if(!stack.isEmpty()){
                    System.out.println(stack.peek());
                }else{
                    System.out.println(-1);
                }
            }else if( line[0].equals("size")){
                System.out.println(stack.size());
            }else if( line[0].equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }



        }
    }
}