/*

*/
import java.util.*;


class Solution {
    public int[] solution(String s) {
        int[] answer =new int[s.length()];
        char[] text=s.toCharArray();
        
        
        HashMap<Character, Integer> map=new HashMap<>();
        
        for(int i=0;i<text.length;i++){
            
            if(!map.containsKey(text[i])){
                answer[i]=-1;
                
            }else{
                answer[i]=i+1-map.get(text[i]);
            }
            // System.out.println( text[i ] + " , " + answer[i]);
            map.put(text[i],i+1);
            
                
        }
        
        return answer;
    }
}