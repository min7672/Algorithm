import java.util.Scanner;

public class Main {
    /*
    23=> N 참가자 수
    3 1 4 1 5 9=> S, M ,L, XL, XXL, XXXL 신청자수 
    5 7 => T, P
    T셔츠 남아도됨 부족하면안됨, 펜 남으면 안됨
    */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in)  ;
        int N=Integer.parseInt(sc.nextLine());
        String []size=sc.nextLine().split(" ");
        String bundle[]=sc.nextLine().split(" ");
        int T=Integer.parseInt(bundle[0]);
        int P=Integer.parseInt(bundle[1]);
        int cnt=0;
        for(int i=0;i<size.length;i++){
            int temp= Integer.parseInt(size[i]);
            cnt+=(int)temp/T;
            if(temp%T!=0){
                cnt++;
            }
            
        }
        System.out.println(cnt);
        System.out.println(((int)N/P)+" "+(N%P));
        
    }
}
