import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] tmp= sc.nextLine().split(" ");
        Long a=Long.parseLong(tmp[0]);
        Long b=Long.parseLong(tmp[1]);
        Long result=(long) 0;
        if( a>b){
            result=a-b;
        }else{
            result=b-a;
        }
        System.out.println(result);

    }
}
