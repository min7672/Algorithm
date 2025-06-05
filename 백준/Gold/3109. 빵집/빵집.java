import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char arr[][];
    static int R, C;
    static int result;
    static boolean[][] dp;
    static int[][] delta = {{-1, 1}, {0, 1}, {1, 1}}; // Directions: Up-right, Right, Down-right

    static boolean dfs(int x, int y) {
        if (y == C - 1) {
            return true;
        }

        // Memoization check
        if (dp[x][y]) return false;  // If this cell has already been processed and can't reach the end, return false
        
        dp[x][y] = true; // Mark this cell as processed (blocked in terms of paths)

        for (int i = 0; i < 3; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];

            if (nx >= 0 && nx < R && ny < C && arr[nx][ny] == '.' && !dp[nx][ny]) {
                if (dfs(nx, ny)) {
                    return true; // If one path leads to the rightmost column, return true
                }
            }
        }
        return false; // No valid path found from here
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        R = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);

        arr = new char[R][C];
        dp = new boolean[R][C]; // Memoization table

        // Input grid
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        result = 0;

        // Start DFS from the leftmost column (0th column)
        for (int i = 0; i < R; i++) {
            if (arr[i][0] == '.' && !dp[i][0]) { // If it's not blocked and not processed
                if (dfs(i, 0)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
