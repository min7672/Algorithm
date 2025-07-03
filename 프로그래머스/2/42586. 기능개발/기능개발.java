import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int cnt=0;

        Deque<Integer> queue= new ArrayDeque<>();
        ArrayList<Integer> result= new ArrayList();
        for(int i=0; i<progresses.length; i++ ){
            
            int toDo=100-progresses[i];
            int finishDay=toDo%speeds[i]!=0? toDo/speeds[i]+1:toDo/speeds[i];

            if(queue.isEmpty() || queue.peekFirst()>=finishDay){
                queue.addLast(finishDay);
                
            }else if(queue.peekFirst()<finishDay){
                result.add(queue.size());
                queue.clear();
                queue.addLast(finishDay);                    
            }
        }

        if(!queue.isEmpty())result.add(queue.size());
        int answer[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}