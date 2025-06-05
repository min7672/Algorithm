import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    // 팩토리얼 계산 함수(BigInteger 사용)
    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    // 조합 계산 함수(BigInteger 사용)
    static BigInteger combination(BigInteger n, BigInteger r) {
        if (r.compareTo(n) > 0) return BigInteger.ZERO;  // 조합이 불가능한 경우
        return factorial(n).divide(factorial(r).multiply(factorial(n.subtract(r))));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M: 돌의 종류 수
        int M = Integer.parseInt(br.readLine());

        // 각 종류의 돌의 개수를 저장할 배열
        int[] rockCnts = new int[M];
        String[] nums = br.readLine().split(" ");

        // 전체 돌의 개수
        BigInteger totalCnt = BigInteger.ZERO;
        for (int i = 0; i < M; i++) {
            rockCnts[i] = Integer.parseInt(nums[i]);
            totalCnt = totalCnt.add(BigInteger.valueOf(rockCnts[i]));
        }

        // K: 선택할 돌의 개수
        int K = Integer.parseInt(br.readLine());

        // 전체 경우의 수 (totalCnt에서 K개를 고를 수 있는 경우의 수)
        BigInteger totalWays = combination(totalCnt, BigInteger.valueOf(K));

        // 각 종류의 돌을 고를 수 있는 확률 계산
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < M; i++) {
            if (rockCnts[i] >= K) {
                // 해당 종류에서 K개를 고를 수 있는 경우의 수를 전체 경우의 수로 나누어 확률을 구함
                sum = sum.add(combination(BigInteger.valueOf(rockCnts[i]), BigInteger.valueOf(K)));
            }
        }

        // 확률 계산 (sum / totalWays) 결과 출력
        // 확률을 계산하려면 실수로 출력해야 하므로 BigDecimal 사용
        if (totalWays.equals(BigInteger.ZERO)) {
            System.out.println("0");
        } else {
            // 확률을 실수로 출력하기 위해 BigDecimal로 변환 후 출력
            System.out.println(new java.math.BigDecimal(sum).divide(new java.math.BigDecimal(totalWays), 10, java.math.BigDecimal.ROUND_HALF_UP).doubleValue());
        }
    }
}
