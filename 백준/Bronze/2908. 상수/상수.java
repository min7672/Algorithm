import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []num=sc.nextLine().split(" ");
        
        int a=Integer.parseInt(num[0].charAt(2)+""+num[0].charAt(1)+num[0].charAt(0));
        int b=Integer.parseInt(num[1].charAt(2)+""+num[1].charAt(1)+num[1].charAt(0));
        int maxNum=b;
        if(a>b)maxNum=a;
        System.out.println(maxNum);
        
    }
}
