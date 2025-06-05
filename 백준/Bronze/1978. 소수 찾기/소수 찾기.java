import java.util.Scanner;

public class Main {
    public static boolean checkPrime(int num){
        if( num==1){
            return false;
        }
        for( int i=2; i<= Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        int cnt=0;

        for(int i=0;i<N;i++){
            int num=sc.nextInt();
            if(checkPrime(num)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }    
}
