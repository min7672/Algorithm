import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb= new StringBuilder();
        for(int i=n;i>=1;i--){
            sb.setLength(0);
            for(int j=0;j<i;j++){
                sb.append('*');
            }
            System.out.println(sb.toString());
        }
    }
}