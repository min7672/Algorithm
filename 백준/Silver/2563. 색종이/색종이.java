import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arr[][]=new int[100][100];
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                arr[i][j]=0;
            }
        }
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            for(int k=a;k<a+10;k++){
                for(int l=b;l<b+10;l++){
                    arr[k][l]++;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(arr[i][j]>0)
                    cnt++;
            }
        }
        System.out.println(cnt);
        
        
        
    }
}