/*
데이터 분석 작업

data[idx]={code, date, maximum, remain}
만족하는 조건으로 정렬 
ex 제조일이 20300501 이전인 물건들을 현재 수량이 적은 순서
문자열 정렬비교하면 대강 가능하다 
sort_by 결과 에서 조건 안되면 제외 출력 

*/
import java.util.*;

class Solution {
    static int idx;
    public static int parsIdx(String base){
        int num =0;
        if("code".equals(base)){num=0;}
        if("date".equals(base)){num=1;}
        if("maximum".equals(base)){num=2;}
        if("remain".equals(base)){num=3;}
        return num;
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> result=new ArrayList<>();
        
        idx=parsIdx(sort_by);
        
        //오름 차순 정렬 
        Arrays.sort(data , ( a, b)-> a[idx]-b[idx]);
        
        idx=parsIdx(ext);
        for(int i=0;i<data.length;i++){
            if(data[i][idx]<val_ext){
                result.add(data[i]);
            }
        }
        int[][] answer = result.toArray(new int[0][]);
        return answer;
    }
}