import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char word[]=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<word.length;i++){
            if(word[i]=='('){
                stack.push(word[i]);
            }else{
                if( stack.isEmpty() ||stack.peek()!='('){
                    answer=false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty())answer=false;

        return answer;
    }
}