import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int delta[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 대각선 방향
    static int[][] arr;
    static boolean[][] visited;
    static boolean[] dessert;
    static int N, maxDessert;

    static void solution(int x, int y, int startX, int startY, int count, int dir) {
        for (int i = dir; i < 4; i++) { // 현재 방향 유지 또는 회전
            int nextX = x + delta[i][0];
            int nextY = y + delta[i][1];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue; // 경계 체크
            if (nextX == startX && nextY == startY && count >= 4) { // 시작점으로 돌아왔을 때
                maxDessert = Math.max(maxDessert, count);
                return;
            }
            if (visited[nextX][nextY] || dessert[arr[nextX][nextY]]) continue; // 방문 및 중복 디저트 체크

            // 방문 처리
            visited[nextX][nextY] = true;
            dessert[arr[nextX][nextY]] = true;
            solution(nextX, nextY, startX, startY, count + 1, i);
            visited[nextX][nextY] = false;
            dessert[arr[nextX][nextY]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            maxDessert = -1;

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    dessert = new boolean[101];
                    visited[i][j] = true;
                    dessert[arr[i][j]] = true;
                    solution(i, j, i, j, 1, 0);
                }
            }
            System.out.println("#" + test_case + " " + maxDessert);
        }
    }
}
