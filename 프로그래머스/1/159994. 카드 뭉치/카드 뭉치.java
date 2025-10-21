/*
단어 카드뭉치
2 덱에서 하나는 써야 다음을 진행
단어뭉치 순서 변경은 불가
*/
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int leftIdx=0;
        int rightIdx=0;
        int idx=0;
        
        for(int i=0;i<goal.length;i++){
            if(leftIdx<cards1.length && cards1[leftIdx].equals(goal[idx])){
                leftIdx++;
                idx++;
            }else if(rightIdx<cards2.length && cards2[rightIdx].equals(goal[idx])){
                rightIdx++;
                idx++;
            }else{
                answer="No";
                break;
            }
        }
        
        return answer;
    }
}