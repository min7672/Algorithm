import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        
        for(int i=0; i<t;i++){
            String []tmp=sc.nextLine().split(" ");
            
            System.out.println(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]));
        }
    }
}
