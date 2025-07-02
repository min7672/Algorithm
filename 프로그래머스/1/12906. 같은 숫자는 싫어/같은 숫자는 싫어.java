import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue= new ArrayDeque<>();
        queue.add(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(queue.peekLast()==arr[i]){
                continue;
            }else{
                queue.add(arr[i]);
            }
        }
        int []answer=new int[queue.size()];
        int idx=0;
        while(!queue.isEmpty()){
            answer[idx++]=queue.poll();
        }

        return answer;
    }
}