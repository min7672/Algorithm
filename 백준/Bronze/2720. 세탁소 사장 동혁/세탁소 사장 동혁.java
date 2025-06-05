import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        int money[]={25, 10, 5,1};
        int changes[]={0,0,0,0};
        for(int i=0;i<t;i++){
            int tmp =Integer.parseInt(sc.nextLine());
            for(int j=0;j<4;j++){
                changes[j]=tmp/money[j];
                tmp=tmp%money[j];
                System.out.print(changes[j]+" ");
            }
            System.out.print("\n");
        }
        
    }
}
