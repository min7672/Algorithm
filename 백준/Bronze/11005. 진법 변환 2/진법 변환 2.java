import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []words=sc.nextLine().split(" ");
        int N=Integer.parseInt(words[0]);
        int B=Integer.parseInt(words[1]);
        int num=N;
        char tmp=' ';
        ArrayList<Character> result_r= new ArrayList<Character>();
        while(num/B>=1){
            if(num%B>9){
                tmp =(char)(num%B+55);
            }else{
                tmp =(char)(num%B+48);
            }
            result_r.add(0,tmp);
            num=num/B;
            
        }
        if(num%B>9){
            tmp =(char)(num%B+55);
        }else{
            tmp =(char)(num%B+48);
        }
        result_r.add(0,tmp);
        
        for(int i=0;i<result_r.size();i++){
            System.out.print(result_r.get(i)+"");
        }

    }
}