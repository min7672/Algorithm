import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        int is42[]=new int[42];
        for(int i=0;i<42;i++){
            is42[i]=0;
        }
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt()%42;
            is42[arr[i]]+=1;
        }
        int cnt=0;
        for(int i=0;i<42;i++){
            if(is42[i]!=0){
                cnt++;
            }
        }
        System.out.println(cnt);
        
        

    }
}
