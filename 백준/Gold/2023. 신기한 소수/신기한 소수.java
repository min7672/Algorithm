import java.util.Scanner;

public class Main {
    static int N;
    static boolean visited[];
    static StringBuilder sb;
    
    static int x;
    static boolean checkPrime(int number){
        if(number==1)return false;
        
        
        for(int i=2;i<=Math.sqrt((double)number);i++){
            
            if(number%i==0){
                // System.out.println("none Prime :"+ number);
                return false;
            }
        }
        return true;
    }
    static void permu(int depth){
        
        if(sb.length()>0){
            x=Integer.parseInt(sb.toString());
            // System.out.println(x);
            if(!checkPrime(x))return;
        }
        

        if(depth==N){
            x=Integer.parseInt(sb.toString());
            // if(checkPrime(x))  System.out.println(x);
            System.out.println(x);
            
            return;
        }
        for(int i=1;i<=9;i++){
            sb.append(i);
            permu(depth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        visited=new boolean[N+1];
        sb=new StringBuilder();
        permu(0);
    }
}
