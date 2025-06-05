import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char s[]=sc.nextLine().toCharArray();
        int arr[]=new int[26];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        for(int i=0;i<s.length;i++){
            int tmp=(int)s[i]-(int)'a';
            
            if(arr[tmp]==-1) arr[tmp]=i;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}