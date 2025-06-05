
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		int T= Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++){
			char []ground=sc.nextLine().toCharArray();
            int cnt=0;
            
            for( int i=0; i<ground.length-1; i++){
                if(ground[i]=='(' &&ground[i+1]=='|')cnt++;
                if(ground[i]=='(' &&  ground[i+1]==')' )cnt++;                
                if(ground[i]=='|' && ground[i+1]==')') cnt++;
            }
            
            System.out.printf("#%d %d\n",test_case, cnt);
		}
	}
}