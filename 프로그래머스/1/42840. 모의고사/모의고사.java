import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer_cnt = new int[3];
        int[] supo1={1,2,3,4,5};
        int[] supo2={2,1,2,3,2,4,2,5};
        int[] supo3={3,3,1,1,2,2,4,4,5,5};
        
        
        for(int i=0;i<answers.length;i++){
            //수포자 1 비교
            if(answers[i] == supo1[i%supo1.length]){
                answer_cnt[0]++;
            }
            //수포자 2 비교
            if(answers[i] == supo2[i%supo2.length]){
                answer_cnt[1]++;
            }
            
            //수포자 3 비교
            if(answers[i] == supo3[i%supo3.length]){
                answer_cnt[2]++;
            }
        }
        int max_cnt=0;
        for(int i=0;i<3;i++){
            if(max_cnt<answer_cnt[i])max_cnt=answer_cnt[i];
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            if(max_cnt==answer_cnt[i])result.add(i+1);
        }
        int answer[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }

}