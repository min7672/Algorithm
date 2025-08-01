import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;
    static StringBuilder sb;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] =new int[N];
        
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        init();
        run(N, arr);
    }
    static void init(){

        stack = new Stack<>();
        sb = new StringBuilder();

    }

    static void run(int n,int target[]){
        int num=1;
        int tar_idx=0;
        while(  tar_idx<target.length ){
            if(stack.isEmpty() ){               
                stack.add(num++);
                sb.append("+\n");   
            }else{
                if(stack.peek()==target[tar_idx]){
                    stack.pop();
                    sb.append("-\n");
                    tar_idx++;
                }else if(stack.peek()<num && (num<=n)){
                    stack.add(num++);
                    sb.append("+\n");
                }else{
                    break;
                }
            }       
        }
        
        if(tar_idx==n){
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
            
        }
    }
}