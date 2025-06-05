import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] word=sc.nextLine().toUpperCase().toCharArray();
        int []cnt=new int[26];
        for(int i=0;i<cnt.length;i++){
            cnt[i]=0;
        }
        for(int i=0;i<word.length;i++){
            cnt[word[i]-'A']+=1;
        }
        int mod=0;
        
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>cnt[mod]){
                mod=i;
            }
        }
        
        for(int i=0;i<cnt.length;i++){
            if(cnt[mod]==cnt[i]&& mod!=i){
                System.out.println("?");
                return;
            }
        }
        System.out.println((char)(mod+'A'));
    }
}