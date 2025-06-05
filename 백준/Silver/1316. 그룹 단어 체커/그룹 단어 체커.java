import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        int cnt=0;
        for(int i=0;i<t;i++){
            char[] word=sc.nextLine().toCharArray();
            int apla[]=new int[26];
            for(int j=0;j<26;j++){
                apla[j]=0;
            }
            for(int j=0;j<word.length-1;j++){
                apla[word[j]-'a']=1;
                if(word[j]!=word[j+1]&& apla[word[j+1]-'a']!=0){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(t-cnt);
    }
}