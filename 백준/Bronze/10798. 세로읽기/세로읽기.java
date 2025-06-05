import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []word=new String[5];
        int max_length=0;
        for(int i=0;i<5;i++){
            word[i]=sc.nextLine();
            if(max_length<word[i].length()){
                max_length=word[i].length();
            }
        }
        for(int j=0;j<max_length;j++){
            for(int i=0;i<5;i++){
                if(j<word[i].length()){
                    System.out.print(word[i].charAt(j)+"");
                }
            }
        }
    }   
}
