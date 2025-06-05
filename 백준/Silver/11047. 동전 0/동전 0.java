import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String info[]=sc.nextLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int K=Integer.parseInt(info[1]);
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int sum=0;
        for(int i=N-1;i>=0;i--){
            
            sum+=K/arr[i];
            K=K%arr[i];
            if(K==0)break;
        }
        System.out.println(sum);
    }    
}
