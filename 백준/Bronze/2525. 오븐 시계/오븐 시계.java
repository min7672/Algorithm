import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int timer = sc.nextInt();
        // h+timer/60
        m=m+(timer%60);
        if(m>=60){
            h=h+1;
        }
        System.out.println((h+timer/60)%24+" "+ m%60);

        
    }
}
