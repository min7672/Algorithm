import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []words=sc.nextLine().split(" ");
        char []numbers=words[0].toCharArray();
        int num=Integer.parseInt(words[1]);
        int result=0;
        for(int i=numbers.length-1;i>=0;i--){
            if(numbers[i]>='A'){
                result+=((int)(numbers[i]-'A')+10)*Math.pow(num,(numbers.length-1-i));
            }else{
                result+=((int)(numbers[i]-'0'))*Math.pow(num,(numbers.length-1-i));
            }
            
        }
        System.out.println(result);

    }
}