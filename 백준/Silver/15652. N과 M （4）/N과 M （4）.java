import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int M;

    static StringBuilder sb;

    static void permu(int idx, int start, BufferedWriter bw) throws IOException {
        if (idx == M) {
            bw.write(sb.toString() + "\n");
            return;
        }

        for (int i = start; i <= N; i++) {  // start에서부터 숫자를 선택하도록 변경
            sb.append(i).append(" ");  // 숫자 추가
            permu(idx + 1, i, bw);    // 현재 숫자 i를 포함하여 그 이상을 선택
            sb.delete(sb.length() - 2, sb.length());  // 마지막 공백 제거
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        sb = new StringBuilder();

        permu(0, 1, bw);  // 재귀 호출을 시작하면서 1부터 시작
        bw.flush();
    }
}
