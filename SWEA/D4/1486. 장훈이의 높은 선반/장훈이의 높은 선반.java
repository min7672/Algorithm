import java.util.Scanner;

public class Solution {
    static int N;
    static int B;
    static int iHeights[];
    static boolean visited[];
    
    static int solution(){
        int min_value=Integer.MAX_VALUE;
        for(int mask=0;mask< (1<<N);mask++){
            int sum=0;
            for(int j=0;j<N;j++){
                if((mask & (1<<j))!=0){
                    sum+=iHeights[j];
                    
                }
            }
            
            sum=sum-B;
            
            if(sum<0)sum=Integer.MAX_VALUE;

            if(min_value>sum)min_value=sum;
        }
        return min_value;

    }
    public static void main(String[] args) {    
        Scanner sc= new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        for(int test_case=1;test_case<=T;test_case++){
            String info[]=sc.nextLine().split(" ");
            N=Integer.parseInt(info[0]);
            B=Integer.parseInt(info[1]);
            String heights[]=sc.nextLine().split(" ");
            iHeights=new int[N];
            visited=new boolean[N];

            for(int i =0;i<N;i++){
                iHeights[i]=Integer.parseInt(heights[i]);
            }
            System.out.printf("#%d %d\n",test_case,solution());
        }
    }
}
