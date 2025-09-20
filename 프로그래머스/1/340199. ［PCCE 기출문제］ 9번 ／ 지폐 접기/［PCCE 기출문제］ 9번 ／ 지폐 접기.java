/* 
지갑의 크기 30 * 15이고 지폐의 크기 26 * 17
한번 접어 13 * 17 크기 90도 회전 지갑 들어감

지폐를 접는 규칙
항상 길이가 긴 쪽,홀수였다면 접은 후 소수점 이하는 버립
접힌 지폐를 또는 90도 돌려 그만 

출력 :지폐를 최소 몇 번 접는지

*/

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            //지폐를 회전하여 넣을 수 있는지 체크
            if((wallet[0]>=bill[0]&&wallet[1]>=bill[1])||(wallet[0]>=bill[1]&&wallet[1]>=bill[0])){
                break;
            }
            if(bill[0]>=bill[1]){
                bill[0]=(int)(bill[0]/2);
            }else{
                bill[1]=(int)(bill[1]/2);
            }
            answer++;
        }
        return answer;
    }
}