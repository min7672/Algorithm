import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0]-1;
            int end=commands[i][1];
            int k=commands[i][2]-1;
            int arr[]=new int[end-start];
            for(int j=start,l=0;j<end;j++,l++){
                arr[l]=array[j];
            }
            Arrays.sort(arr);
            result.add(arr[k]);
        }

        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}