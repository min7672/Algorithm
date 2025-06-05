import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static boolean playList[][]; // 각 팀이 어떤 악기를 연주할 수 있는지
    static boolean selected[];   // 팀 선택 여부
    static boolean playes[];     // 각 악기 연주 여부
    static int maxCoveredInstruments; // 최대 커버 가능한 악기의 수
    static int instrumentResult; // 최소 팀 수

    // 팀을 선택하는 재귀 함수
    public static void combi(int idx, int depth) {
        if (depth > 0) {
            playes = new boolean[M]; // 악기 연주 여부를 나타내는 배열
            int ins_cnt = 0; // 연주한 악기의 수
            int instrumentCnt = 0; // 선택된 팀의 수

            // 선택된 팀들이 연주할 수 있는 악기를 체크
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    instrumentCnt++;
                    for (int j = 0; j < M; j++) {
                        if (playList[i][j] && !playes[j]) {
                            playes[j] = true; // 해당 악기를 연주할 수 있으면 true로 설정
                            ins_cnt++; // 연주한 악기의 수를 증가
                        }
                    }
                }
            }

            // 최대 커버 가능한 악기 수를 갱신하고, 그에 해당하는 최소 팀 수를 구함
            if (ins_cnt > maxCoveredInstruments) {
                maxCoveredInstruments = ins_cnt;
                instrumentResult = instrumentCnt;
            } else if (ins_cnt == maxCoveredInstruments && instrumentCnt < instrumentResult) {
                instrumentResult = instrumentCnt;
            }
        }

        if (idx == N) return; // 모든 팀을 고려했으면 종료

        // 팀을 선택한 경우
        selected[idx] = true;
        combi(idx + 1, depth + 1);

        // 팀을 선택하지 않은 경우
        selected[idx] = false;
        combi(idx + 1, depth);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        playList = new boolean[N][M];
        String[] line;

        // 플레이리스트 입력
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            char[] lineInfo = line[1].toCharArray();
            for (int j = 0; j < M; j++) {
                if (lineInfo[j] == 'Y') playList[i][j] = true;
            }
        }

        selected = new boolean[N];
        maxCoveredInstruments = 0; // 최대 커버 가능한 악기 수 초기화
        instrumentResult = Integer.MAX_VALUE; // 최소 팀 수를 무한대로 초기화

        // 가능한 모든 팀 조합을 검사
        combi(0, 0);

        // 결과 출력
        if (maxCoveredInstruments == 0) {
            // 악기를 하나도 커버할 수 없다면 -1 출력
            System.out.println("-1");
        } else {
            // 최대 악기를 커버할 수 있는 최소 팀 수 출력
            System.out.println(instrumentResult);
        }
    }
}
