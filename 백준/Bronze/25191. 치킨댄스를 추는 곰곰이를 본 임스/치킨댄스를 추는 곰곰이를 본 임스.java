import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        StringTokenizer st=new StringTokenizer(sc.nextLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        if(N<=(A/2+B))System.out.println(N);
        else System.out.println(((int)A/2+B));
    }
}
