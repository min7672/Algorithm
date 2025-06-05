import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char []dial=sc.nextLine().toCharArray();
        //             2  3     4      5    6     7     9     9     10
        String num[]={"","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ",""};
        int time_sum=0;
        for(int i=0;i<dial.length;i++){
            for(int j=0;j<num.length;j++){
                if(num[j].contains(dial[i]+""))
                time_sum+=j+2;
                
            }
        }
        System.out.println(time_sum);
    }
}
