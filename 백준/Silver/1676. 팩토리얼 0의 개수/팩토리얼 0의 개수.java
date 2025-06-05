import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger fc(BigInteger N) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(N) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int cnt = 0;

        
        char tmp[] = (fc(BigInteger.valueOf(N)) + "").toCharArray();
        for (int j = tmp.length - 1; j >= 0; j--) {
            if (tmp[j] == '0') cnt++;
            else break;
        }

        System.out.println(cnt);
    }
}
