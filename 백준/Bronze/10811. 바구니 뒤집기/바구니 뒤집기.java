import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int arr[]=new int[M];
        for(int i=0;i<M;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<N;i++){
            int start=sc.nextInt()-1;
            int end=sc.nextInt()-1;
            for(int j=0;j<=(end-start)/2;j++){
                int tmp=arr[j+start];
                arr[j+start]=arr[end-j];
                arr[end-j]=tmp;
            }
            
        }
        for(int z=0;z<M;z++){
            System.out.print(arr[z]+" ");
        }
    }
}
