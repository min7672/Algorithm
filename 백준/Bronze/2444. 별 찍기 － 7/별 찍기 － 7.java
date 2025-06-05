import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //2×N-1
        int num=sc.nextInt();
        for(int i=1;i<=num;i++){
            for(int j=0;j<((2*num-1)-(2*i-1))/2;j++){System.out.print(" ");}
            for(int k=0;k<2*i-1;k++){System.out.print("*");}
            
            System.out.println("");
        }
        for(int i=num-1;i>0;i--){
            for(int j=0;j<((2*num-1)-(2*i-1))/2;j++){System.out.print(" ");}
            for(int k=0;k<2*i-1;k++){System.out.print("*");}
            
            System.out.println("");
        }

    }
}
