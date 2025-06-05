import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums[] = sc.nextLine().split(" ");
        int arr[]=new int[5];
        int sum=0;
        for(int i=0;i<5;i++){
            arr[i]=Integer.parseInt(nums[i]);   
            sum+=(int)Math.pow(arr[i], 2);
        }
        System.out.println(sum%10);



    }
}
