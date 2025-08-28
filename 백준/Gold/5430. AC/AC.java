import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 새로운 언어 AC, 정수 배열에 연산을 하기 위해 만든 언어
 * 함수 R(뒤집기)과 D(버리기)
 * 배열이 비어있는데 D를 사용한 경우에는 에러
 * T <=100
 * 수행할 함수  1<P <10^5
 *  n <10^5
 * 배열 원소 x 100이하
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        String tmp="";
        
        for(int test_case=1;test_case<=T;test_case++){
            
            char []command =br.readLine().toCharArray();
            
            int N=Integer.parseInt(br.readLine());
            
            tmp=br.readLine();
            st=new StringTokenizer(tmp.substring(1, tmp.length()-1));

            int []nums=new int[N];
            for(int i=0;i<N;i++){
                nums[i]=Integer.parseInt(st.nextToken(","));
            }
            
            // 시작,  끝, 포인팅 위치 
            int start=0;
            int end=N;
            int loc=0;
            boolean isFront=true;
            String result="";
            for(int i=0;i<command.length;i++){
                if(command[i]=='R'){
                    isFront=!isFront;
                }else if(command[i]=='D'){
                    if(start >= end){ // 비었는데 삭제 시도
                        result = "error";
                        break;
                    }
                    if(isFront) start++;
                    else end--;
                }
            }

            if(!result.equals("error")){
                 StringBuilder sb = new StringBuilder();
                sb.append("[");
                if(start < end){ // 원소가 남아 있을 때만
                    if(isFront){
                        for(int i=start; i<end; i++) sb.append(nums[i]).append(",");
                    } else {
                        for(int i=end-1; i>=start; i--) sb.append(nums[i]).append(",");
                    }
                    sb.deleteCharAt(sb.length()-1); // 마지막 , 제거
                }
                sb.append("]");
                result=sb.toString();
              
            }
            System.out.println(result);
        }
    }   
}
