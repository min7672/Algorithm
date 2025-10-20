/*
페인트 n 미터 벽 
n per 1m 
- 롤러 세로 라인 벗어나지 말기 
- 라인 통으로 칠하기 

*/
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pre=-m;
        
        for(int i=0;i<section.length;i++){
            // System.out.println(pre + " , "+ section[i]);
            if(!(pre<=section[i] && section[i]<pre+m)){
                answer++;
                
                pre=section[i];
            }
            
        }
        

        return answer;
    }
}