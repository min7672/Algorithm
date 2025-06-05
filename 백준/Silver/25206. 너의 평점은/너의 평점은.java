import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double result=0.0;
        double total=0.0;

        for(int i=0;i<20;i++){
            String []tmp=sc.nextLine().split(" ");
            double score=0.0;
            
            if(tmp[2].equals("P")){
                continue;
            }
            if(tmp[2].equals("A+")){
                score=4.5;
            }else if(tmp[2].equals("A0")){
                score=4.0;
            }else if(tmp[2].equals("B+")){
                score=3.5;
            }else if(tmp[2].equals("B0")){
                score=3.0;
            }else if(tmp[2].equals("C+")){
                score=2.5;
            }else if(tmp[2].equals("C0")){
                score=2.0;
            }else if(tmp[2].equals("D+")){
                score=1.5;
            }else if(tmp[2].equals("D0")){
                score=1.0;
            }else if(tmp[2].equals("F")){
                score=0;
            }
            
            result+=score*Double.parseDouble(tmp[1]);
            total+=Double.parseDouble(tmp[1]);
        }
        System.out.println(result/total);
    }
}
