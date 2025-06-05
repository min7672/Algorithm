import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        char result='F';
        if(a>=90 && a<=100)result='A';
        if(a>=80 && a<90)result='B';
        if(a>=70 && a<80)result='C';
        if(a>=60 && a<70)result='D';
        System.out.println(result);
            

        
    }
}
