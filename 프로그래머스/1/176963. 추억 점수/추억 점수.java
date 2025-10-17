/*
추억점수 
이름 []
점수 []
사진[num][names]
*/

import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> dic=new HashMap<>();
        for(int i=0;i<name.length;i++){
            dic.put(name[i],yearning[i]);
            // System.out.println(name[i]+", " + yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++){
            int result=0;
            for(int j=0;j<photo[i].length;j++){
                if(dic.containsKey(photo[i][j])){
                    
                    result+=dic.get(photo[i][j]);
                }   
            }
            
            answer[i]=result;
        }
        return answer;
    }
}