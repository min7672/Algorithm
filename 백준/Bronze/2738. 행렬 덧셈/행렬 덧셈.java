import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []size=sc.nextLine().split(" ");
        int m=Integer.parseInt(size[0]);
        int n=Integer.parseInt(size[1]);
        String [][]arr1=new String[m][n];
        String [][]arr2=new String[m][n];
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextLine().split(" ");
        }
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextLine().split(" ");
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print((Integer.parseInt(arr1[i][j])+Integer.parseInt(arr2[i][j]))+" ");
            }
            System.out.println("");
        }
        


    }
}
