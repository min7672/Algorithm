import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=((int)s.charAt(i)-(int)'0');
        }
        System.out.println(sum);
    }
}
