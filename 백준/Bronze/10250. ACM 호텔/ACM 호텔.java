import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String tmp[] = sc.nextLine().split(" ");
            int H = Integer.parseInt(tmp[0]);
            int W = Integer.parseInt(tmp[1]);
            int N = Integer.parseInt(tmp[2]);
            
            // 층 계산
            int floor = N % H == 0 ? H : N % H;
            // 호 계산
            int room = (N - 1) / H + 1;
            
            System.out.println(floor * 100 + room);
        }
    }
}
