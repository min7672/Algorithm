import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        while(true){
            try{
                String []tmp=sc.nextLine().split(" ");
                System.out.println(Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]));
            }catch(NoSuchElementException e){
                break;
            }
        
            
        }
    }
}
