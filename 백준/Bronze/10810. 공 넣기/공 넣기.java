import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];
        int M=sc.nextInt();
        for(int i=0;i<N;i++){
            arr[i]=0;
        }
        for(int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            
                
            for(int j=a-1;j<b;j++){
                if(arr[j]==0 ||arr[j]!=c){
                    arr[j]=c;
                }
            }
                
            
            
        }
        for(int z=0;z<N;z++){
            System.out.print(arr[z]+" ");
        }
        
    }    
}
