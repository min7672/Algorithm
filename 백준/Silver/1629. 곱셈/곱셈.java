import java.util.Scanner;

public class Main {

    public static long power(long A, long B, long C) {
        if (B == 0) {
            return 1; // A^0 = 1
        }
        long half = power(A, B / 2, C);
        long halfSquared = (half * half) % C;

        if (B % 2 == 0) {
            return halfSquared;
        } else {
            return (halfSquared * A) % C;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.println(power(A, B, C));
    }
}
