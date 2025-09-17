class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int preSec=0;
        int userHealth=health;

        //for문 사용 사유 공격이 끝난 직후 남은 체력
        for(int i=0;i<attacks.length;i++){
            int curTime=attacks[i][0];
            int curAttack=attacks[i][1];
            
            int past=curTime-preSec;
            if(past>1){
                past-=1;
                userHealth+=past*bandage[1]+(int)(past/bandage[0])*bandage[2];

                
                userHealth=Math.min(health,userHealth );
            }
            
            preSec=curTime;
            
            userHealth-=curAttack;
            if(userHealth<=0){
                answer=-1;
                break;
            }

        }
        return answer!=-1? userHealth:answer;
    }
}