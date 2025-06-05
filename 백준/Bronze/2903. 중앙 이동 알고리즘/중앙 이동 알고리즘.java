import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();

        int curResult=0;

        for(int i=1;i<num+1;i++){
            int tmp=((int)Math.sqrt(Math.pow(4,i))+1);
    
            
            curResult= tmp*tmp;
            
        }
        System.out.println(curResult);
    }
}
