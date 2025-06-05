import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String word[]=sc.nextLine().split(" ");
        int cnt=word.length;
        for(int i=0;i<word.length;i++){
            if(word[i].trim().equals(""))cnt--;
        }
        
        System.out.println(cnt);

    }   
}
