import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ser = sc.nextLine();
        String[] num_arr=ser.split(" ");
        long a=Long.parseLong(num_arr[0].strip()) ;
        long b=Long.parseLong(num_arr[1].strip()) ;
        long c=Long.parseLong(num_arr[2].strip());
        
        System.out.println(a+b+c);
    }    
}
