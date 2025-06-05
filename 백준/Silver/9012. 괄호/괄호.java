import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        for(int test_case=1;test_case<=T;test_case++){
            Stack<Character> st=new Stack<>();
            char arr[]=sc.nextLine().toCharArray();
            boolean checker=false;
            for(int i=0;i<arr.length;i++){
                if(arr[i]=='('){
                    st.add(arr[i]);
                }
                else if(arr[i]==')'){
                    if(!st.isEmpty()){
                        char tmp=st.peek();
                        if(tmp=='('){
                            st.pop();
                        }else{
                            checker=true;
                            break;
                        }
                    }else{
                        checker=true;
                        break;
                    }
                    
                }               
            }
            if(st.size()>0 || checker)System.out.println("NO");
            else System.out.println("YES");
        }   
        
        
    }
}