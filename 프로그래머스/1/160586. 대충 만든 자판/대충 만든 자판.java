/*
인덱스 수만큼 자판 누르면 이동 
1~100, 중복 허용 

*/
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> dic=new HashMap<>();
        for(int i=0;i<keymap.length;i++){
            char []ins_keymap=keymap[i].toCharArray();
            
            /*해쉬맵 생성*/
            for(int j=0;j<ins_keymap.length;j++){
                if(!dic.containsKey(ins_keymap[j])){
                    dic.put(ins_keymap[j],j+1);
                }else if(dic.get(ins_keymap[j])>j+1){
                    dic.put(ins_keymap[j],j+1);
                    
                }
            }
        }
        
        for(int i=0;i<targets.length;i++){           
            
            char []ins_targets=targets[i].toCharArray();
            /*타겟 순회*/
            for(int j=0;j<ins_targets.length;j++){
                // System.out.println(dic.containsKey(ins_targets[j]) + " , "+ ins_targets[j]);
                if(dic.containsKey(ins_targets[j])){
                    answer[i]+=dic.get(ins_targets[j]);
                }else{
                    answer[i]=-1;
                    break;
                }
            }
        }
            
         
        return answer;
    }
}