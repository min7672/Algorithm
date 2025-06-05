import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄: N (숫자 카드 개수)
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄: 숫자 카드에 적힌 수들
        int[] freq = new int[20000001]; // -10,000,000 ~ 10,000,000 (20,000,001 크기)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            freq[num + 10000000]++;  // -10,000,000 ~ 10,000,000 범위를 0 ~ 20,000,000으로 변환하여 저장
        }

        // 세 번째 줄: M (찾을 숫자 개수)
        int M = Integer.parseInt(br.readLine());

        // 네 번째 줄: 찾을 숫자들
        st = new StringTokenizer(br.readLine());
        
        // StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(freq[target + 10000000]).append(" ");
        }
        
        // 출력
        System.out.println(sb.toString().trim());
    }
}
