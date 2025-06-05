
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) 
	{
		Scanner sc =new Scanner(System.in);
		
		
            int N=sc.nextInt();
            String strVar;
            for( int i =1; i<N+1; i++){
                char []tmp=Integer.toString(i).toCharArray();
                int cnt=0;
                for(int j =0;j<tmp.length;j++){
                    if(tmp[j]=='3' || tmp[j]=='6' || tmp[j]=='9'){
                        cnt++;
                    }
                }
                if( cnt==0){
                    strVar=new String(tmp);
                    System.out.printf("%s ",strVar);
                }else{
                    for(int k=0;k<cnt;k++){
                        System.out.print("-");
                    }
                    System.out.print(" ");
                }   
            }

		
	}
}