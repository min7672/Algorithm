import java.io.*;
import java.util.*;

public class Solution {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    static int N;
    static char[][] board;
    static int[][] mineCount;
    static boolean[][] visited;

    // 지뢰 개수 계산
    static void computeMineCount() {
        mineCount = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*') continue;
                int count = 0;
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == '*') {
                        count++;
                    }
                }
                mineCount[i][j] = count;
            }
        }
    }

    // BFS로 0을 확장
    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (mineCount[p.x][p.y] > 0) continue;
            
            for (int d = 0; d < 8; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            computeMineCount();  // 지뢰 개수 미리 계산

            int clickCount = 0;

            // 먼저 0인 칸을 찾아서 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && mineCount[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        clickCount++;
                    }
                }
            }

            // 남아있는 '.'을 개별적으로 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && !visited[i][j]) {
                        clickCount++;
                        visited[i][j] = true;
                    }
                }
            }

            System.out.println("#" + t + " " + clickCount);
        }
    }
}