/*
s, skip, index 문자열 생성

*/
import java.util.*;

class Solution {
    static public char convert(char target, String next, int idx){
        int tmp=(int)target-97;
        
        for(int i=0;i<idx;i++){
            tmp=(tmp+1)%26;
            
            char cur=(char)(tmp+97);
            if(next.indexOf(cur)!=-1){
                i--;
                continue;
            }            
        }
        
        return (char)(tmp+97);
    }
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb= new StringBuilder();
        char []plainT=s.toCharArray();
        for(int i=0;i< plainT.length;i++){
            sb.append(convert(plainT[i],skip, index));
            
        }
        return sb.toString();
    }
}