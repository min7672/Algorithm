import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int max_num=-1;
        int x=0;
        int y=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int tmp=sc.nextInt();
                if(max_num<=tmp){
                    max_num=tmp;
                    x=i+1;
                    y=j+1;
                }
            }
        }
        System.out.println(max_num);
        System.out.println(x+" "+y);
    }    
}

