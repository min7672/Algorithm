import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int arr[]=new int[9];
        arr[0]=sc.nextInt();
        int max_index=0;
        for(int i=1;i<9;i++){
            arr[i]=sc.nextInt();
            if(arr[max_index]<arr[i]){
                max_index=i;
            }
        }
        System.out.println(arr[max_index]+ "\n"+ (++max_index));
    }
}
