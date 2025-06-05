import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int repeat=sc.nextInt();
            char []text=sc.nextLine().trim().toCharArray();
            char []result=new char[text.length*repeat];

            int k=0;
            for(int j=0;j<text.length;j++){
                for(int z=0;z<repeat;z++){
                    result[k++]=text[j];
                }
                
            }
            System.out.println(result);

        }
    }
}