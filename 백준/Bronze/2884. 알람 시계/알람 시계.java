import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        b=b-45;
        if(b<0){
            b=60+b;
            a=(a+23)%24;
        }
        System.out.println(a+" "+ b);
    }
}
