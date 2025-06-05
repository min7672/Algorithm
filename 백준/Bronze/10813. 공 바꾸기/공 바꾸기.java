import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        

        for(int i=0;i<M;i++){
            int origin=sc.nextInt()-1;
            int target=sc.nextInt()-1;
            int tmp=arr[origin];
            arr[origin]=arr[target];
            arr[target]=tmp;
        }
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
