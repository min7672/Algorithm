/*
재택근무와 함께 출근 희망 시각을 자유,유연근무제,일주일 동안 , 늦지 않고 출근한 직원, 이벤트

> 출근 희망 시각 + 10분까지 어플로 출근
 - 출근 희망 시각이 9시 58분인 직원은 10시 8분까지 출근
 단, 토요일, 일요일의 출근 시각은 이벤트x, 출근 1 once
 
> 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현
 - 10시 13분은 1013, 9시 58분은 958
입력 :  출근 희망 시각과 실제로 출근한 기록
 - 출근 희망 시각을 담은 1차원 정수 배열 schedules
 - 일주일 동안 출근한 시각을 담은 2차원 정수 배열 timelogs
 - 이벤트를 시작한 요일을 의미하는 정수 startday
출력 : 상품을 받을 직원이 몇 명

*/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int j=0;j<schedules.length;j++){
            int hour=schedules[j]/100;
            int miniute=schedules[j]%100;
            miniute+=10;
            if(miniute>=60){
                hour=(hour+1)%24;
                miniute%=60;
            }
            int cnt=0;
            
            for(int i=0;i<7;i++){
                int idx=(startday-1+i)%7;
                
                if(5==idx||idx==6)continue;
                
                int cHour=timelogs[j][i]/100;
                int cMiniute=timelogs[j][i]%100;
                
                int dHour=cHour-hour;
                int dMiniute=cMiniute-miniute;

                if( dHour==0 &&dMiniute<=0 )cnt++;
                if( dHour<0 )cnt++;
                // System.out.print(idx+"\t");
                // System.out.print(hour+ " , "+miniute +"\t");
                // System.out.println(cHour+ " , "+cMiniute +"\t "+ cnt );
                
            }
            
            if(cnt>=5)answer++;
            // System.out.println("======\n"+ answer+"\n============");
        }

        return answer;
    }
}