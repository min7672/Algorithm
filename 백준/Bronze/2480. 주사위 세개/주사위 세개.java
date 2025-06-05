import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int []arr=new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        int result=arr[0];
        if(arr[0]==arr[1] && arr[1]==arr[2]){
            System.out.println(10000+arr[0]*1000);
        }else if(arr[0]!=arr[1] && arr[1]!=arr[2] && arr[2]!=arr[0]){
            
            for(int i=1;i<3;i++){
                if(result<arr[i])result=arr[i];
            }
            System.out.println(result*100);
        }else{
            for(int i=0;i<3;i++){
                if(arr[i]==arr[(i+1)%3]){
                    result=arr[i];
                    break;
                }
            }
            System.out.println(1000+result*100);
            
        }
    }
}
