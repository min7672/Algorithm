import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        
        for(int i=1; i<t+1;i++){
            String []tmp=sc.nextLine().split(" ");
            
            System.out.println("Case #"+i+": "+tmp[0]+" + "+tmp[1]+" = "  +(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1])));
        }
    }
}
