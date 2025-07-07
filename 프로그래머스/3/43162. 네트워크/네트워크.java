import java.util.ArrayDeque;
import java.util.Queue;

//16min
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            Queue<Integer> queue=new ArrayDeque<>();
            if(!visited[i]){
                queue.add(i);
                visited[i]=true;
                answer++;    
            }
            while (!queue.isEmpty()) {
                int cur=queue.poll();
                for(int j=0;j<n;j++){
                    if(computers[cur][j]==1 && !visited[j]){
                        queue.add(j);
                        visited[j]=true;
                    }
                }
            }
        }
        return answer;
    }
}