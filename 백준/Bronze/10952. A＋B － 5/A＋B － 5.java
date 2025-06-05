import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        while(true){
            String []tmp=sc.nextLine().split(" ");
            if(Integer.parseInt(tmp[0])==0 &&0==Integer.parseInt(tmp[1])){
                break;
            }
            
            System.out.println(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]));
        }
    }
}
