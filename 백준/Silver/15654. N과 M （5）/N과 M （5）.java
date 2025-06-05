import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    // 백트래킹을 이용한 순열 생성 함수
    static void permu(int idx, BufferedWriter bw) throws IOException {
        if (idx == M) {
            bw.write(sb.toString() + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;  // 이미 방문한 수는 건너뛰기
            visited[i] = true;  // 수를 선택
            String tmp=arr[i]+" ";
            sb.append(tmp);  // 수를 추가
            permu(idx + 1, bw);  // 다음 자리에 숫자 추가
            sb.delete(sb.length() -tmp.length(), sb.length());  // 마지막 공백 제거
            visited[i] = false;  // 수를 다시 선택할 수 있도록 되돌림
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 수를 오름차순으로 정렬

        visited = new boolean[N];
        sb = new StringBuilder();

        permu(0, bw);  // 백트래킹 시작
        bw.flush();
    }
}
