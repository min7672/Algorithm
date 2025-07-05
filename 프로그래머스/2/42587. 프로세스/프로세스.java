import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static class Process{
        public int x;
        public char id;
        Process(int x,char id){
            this.x=x;
            this.id=id;
        }
    }
    public int solution(int[] priorities, int location) {
                int answer=1;
        PriorityQueue<Process> pq=new PriorityQueue<Process>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o2.x-o1.x;            
            }
        });
        Queue<Process> queue=new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            pq.add(new Process(priorities[i], (char)(i)));
            queue.add(new Process(priorities[i], (char)(i)));
       }
       char loc=(char)(location);

       while (!queue.isEmpty()) {
            Process cur= queue.poll();
            Process pPick= pq.peek();
            if(pPick.x >cur.x){
                queue.add(cur);
            }else{
                if(cur.id==loc){
                    break;
                }else{
                    answer++;
                    pq.poll();
                }       
            }
            
        
       }
        return answer;
    }
}