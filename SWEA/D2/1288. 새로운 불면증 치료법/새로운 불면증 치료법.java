import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N=sc.nextInt();
            
            boolean visit[]={false,false,false,false,false,false,false,false,false,false};
            int visitCnt=0;
            int result=1;
            int tmp;
            
            while(visitCnt<10){
                tmp=N*result;
                result++;
                char []str_arr=Integer.toString(tmp).toCharArray();
                
                for(int i =0;i<str_arr.length;i++){
                    int idx=(int)str_arr[i]-48;
                    
                    if(!visit[idx]){
                        visitCnt++;
                    }

                    visit[idx]=true;

                }
            }
            System.out.printf("#%d %d\n", test_case,(result-1)*N);
		}
	}
}