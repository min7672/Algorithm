import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    static Stack<Character> st;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        // int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=10;test_case++){
            int N=Integer.parseInt(br.readLine());
            char  []words=br.readLine().toCharArray();
            st=new Stack<Character>();
            char tmp=' ';
            int i=0;
            for(i=0;i<N;i++){
                if(words[i]=='(' || words[i]=='[' || words[i]=='<' || words[i]=='{'){
                    st.add(words[i]);
                    continue;
                }
                
                if(words[i]==')'){
                    tmp=st.pop();
                    if(tmp=='(')continue;
                    else break;
                }
                if(words[i]==']'){
                    tmp=st.pop();
                    if(tmp=='[')continue;
                    else break;
                    
                }
                if(words[i]=='>'){
                    tmp=st.pop();
                    if(tmp=='<')continue;
                    else break;
                }
                if(words[i]=='}'){
                    tmp=st.pop();
                    if(tmp=='{')continue;
                    else break;
                }               
            }
            if(i==N)System.out.printf("#%d %d\n",test_case,1);
            else System.out.printf("#%d %d\n",test_case,0);
        }
        
    }
}
