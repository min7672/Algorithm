import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N=Integer.parseInt(sc.nextLine());
            StringTokenizer st;
            int unit=0;
            double score=0.0;
            
            for(int i=0;i<N;i++){
                st=new StringTokenizer(sc.nextLine());
                int ins_unit=Integer.parseInt(st.nextToken());
                unit+=ins_unit;
                score+=ins_unit*Float.parseFloat(st.nextToken());
            }
            System.out.println( unit+" "+(Math.round(score/unit*10)/10.0));
        }
        
   } 
}
