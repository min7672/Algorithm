
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        String []nums=sc.nextLine().split(" ");
        int []arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(nums[i]);
        }

        int i=N-1;
        int j=i;
        int k=i;

        while(i>0 &&arr[i-1]>=arr[i])i--;

        if(i==0){
            System.out.println("-1");
        }else{
            while(j>0 && arr[i-1]>=arr[j])j--;
            swap(arr,i-1,j);
            
            while(i<k)swap(arr, i++, k--);


            for(int z=0;z<N;z++){
                System.out.print(arr[z] + " ");
            }
            System.out.println("");
        }

    }
    public static void swap(int arr[], int x,int y){
        int tmp=arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }
}