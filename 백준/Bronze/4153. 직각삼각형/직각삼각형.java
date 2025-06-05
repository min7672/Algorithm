import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true){
            String len[]=sc.nextLine().split(" ");
            int side[]=new int[len.length];
            int hypotenuse=0;
            if(len[0].equals("0")){
                break;
            }
        
            for(int i=0;i<len.length;i++){
                side[i]=Integer.parseInt(len[i]);
                if(side[hypotenuse]<side[i]){
                    hypotenuse=i;
                }
            }
            double other=0.0;
            for(int i=0;i<len.length;i++){
                if(hypotenuse!=i){
                    other+=Math.pow(side[i], 2);
                                }
            }
            
            
            if(Math.pow(side[hypotenuse], 2)==other){
                System.out.println("right");
            }else{
                System.out.println("wrong");   
            }
        }
    }
}