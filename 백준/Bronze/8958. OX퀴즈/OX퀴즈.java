import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        for(int test_case=1;test_case<=T;test_case++){
            char []line=sc.nextLine().toCharArray();
            int preCnt=1;
            int sum=0;
            for(int i=0;i<line.length;i++){
                if(line[i]=='O'){
                    sum+=preCnt;
                    preCnt++;
                }else{
                    preCnt=1;
                }
            }
            System.out.println(sum);
        }
    }
}
