import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=Integer.parseInt(sc.nextLine());
        int b=Integer.parseInt(sc.nextLine());
        int c=Integer.parseInt(sc.nextLine());
        char value[]=(a*b*c+"").toCharArray();
        int arr[]=new int[10];
        for(int i=0;i<value.length;i++){
            arr[(int)value[i]-48]++;
        }
        for(int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
    }
}
