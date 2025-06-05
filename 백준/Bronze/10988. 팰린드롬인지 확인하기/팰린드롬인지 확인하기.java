import java.util.Scanner;

public class Main {
    public static int palindrome(char []_word){
        //1<=word length<=100 
        int cnt=0;
        int len=_word.length;
        for(int i=0;i<len/2;i++){
            if(_word[i]==_word[len-i-1]) 
                cnt++;
        }

        if(cnt==len/2)
            return 1;
        
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char[] word=sc.nextLine().toCharArray();
        System.out.println(palindrome(word));
    }
}
