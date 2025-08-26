class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true){
            /* 지폐를 좌우로 흔들어서 넣어본다 */
            if((wallet[0]>=bill[0] && wallet[1]>=bill[1])||(wallet[0]>=bill[1] && wallet[1]>=bill[0])){
                break;
            }
            /* 지폐의 가장 긴쪽 접는다 */
            int bigNum_idx=0;
            if(bill[bigNum_idx]<bill[1]){
                bigNum_idx=1;
            }
            bill[bigNum_idx]=(int)(bill[bigNum_idx]/2);
            answer++;
        }

        

        return answer;
    }
}