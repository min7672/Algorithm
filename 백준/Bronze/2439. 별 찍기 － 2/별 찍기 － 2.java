import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            for(int j=num-(i+1);j>0;j--){
                System.out.print(" ");
            }
            for(int j=1;j<i+2;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
