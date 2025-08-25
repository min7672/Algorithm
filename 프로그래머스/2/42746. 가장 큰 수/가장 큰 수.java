import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNums=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strNums[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        if (strNums[0].equals("0")) return "0";
        answer="".join("",strNums);
        return answer;
    }
}