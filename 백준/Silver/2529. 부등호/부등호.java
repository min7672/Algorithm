import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int K;
    static String com[];
    static boolean[] checked=new boolean[10];
    static StringBuilder sb= new StringBuilder();
    static long max=0;
    static String max_result="";
    static String min_result="";
    static long min=Long.MAX_VALUE;
    static void solution(int depth){
        if(sb.length()>=2){
            for(int i=0;i<sb.length()-1;i++){
                char compare=com[i].charAt(0);
                int a=(int)sb.charAt(i)-48;
                int b=(int)sb.charAt(i+1)-48;
                if(compare=='>'){
                    if(!(a>b))return;
                }else if(compare=='<'){ 
                    if(!(a<b))return;
                }
            }
        }

        if(K+1==depth){
            /*출력 */
            
            long ins_value=Long.parseLong(sb.toString());
            if(max<ins_value){
                max=ins_value;
                max_result=sb.toString();
            }
            if(min>ins_value){
                min=ins_value;
                min_result=sb.toString();
            }

            return ;
        }
        for(int i=0;i<10;i++){
            /*1부터 10까지 선택 */
            if(checked[i])continue;
            
            checked[i]=true;
            sb.append(i);
            solution(depth+1);
            sb.deleteCharAt(sb.length() - 1);
            checked[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        
        com=br.readLine().split(" ");
        
        solution(0);
        System.out.println(max_result);
        System.out.printf(min_result);
    }
}
