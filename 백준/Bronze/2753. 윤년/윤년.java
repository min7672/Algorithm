import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        // 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
        if((a%4)==0 && (a%100) !=0 || (a%400==0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}


    