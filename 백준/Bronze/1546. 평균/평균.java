import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];
        float sum=0;
        int max_num=0;
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
            if(arr[i]>max_num)max_num=arr[i];
        }
        for(int i=0;i<N;i++){
            sum+=arr[i]/(float)max_num*100;
            
        }
        System.out.println(sum/(float)N);
    }
    
}

