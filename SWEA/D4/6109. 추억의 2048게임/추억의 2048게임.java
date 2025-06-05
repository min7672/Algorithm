import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void moveLeft(int[][] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int[] newRow = new int[N];
            int index = 0;
            boolean merged = false;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    if (index > 0 && newRow[index - 1] == arr[i][j] && !merged) {
                        newRow[index - 1] *= 2;
                        merged = true;
                    } else {
                        newRow[index++] = arr[i][j];
                        merged = false;
                    }
                }
            }
            arr[i] = newRow;
        }
    }

    public static void moveRight(int[][] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int[] newRow = new int[N];
            int index = N - 1;
            boolean merged = false;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i][j] != 0) {
                    if (index < N - 1 && newRow[index + 1] == arr[i][j] && !merged) {
                        newRow[index + 1] *= 2;
                        merged = true;
                    } else {
                        newRow[index--] = arr[i][j];
                        merged = false;
                    }
                }
            }
            arr[i] = newRow;
        }
    }

    public static void moveUp(int[][] arr) {
        int N = arr.length;
        for (int j = 0; j < N; j++) {
            int[] newCol = new int[N];
            int index = 0;
            boolean merged = false;
            for (int i = 0; i < N; i++) {
                if (arr[i][j] != 0) {
                    if (index > 0 && newCol[index - 1] == arr[i][j] && !merged) {
                        newCol[index - 1] *= 2;
                        merged = true;
                    } else {
                        newCol[index++] = arr[i][j];
                        merged = false;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                arr[i][j] = newCol[i];
            }
        }
    }

    public static void moveDown(int[][] arr) {
        int N = arr.length;
        for (int j = 0; j < N; j++) {
            int[] newCol = new int[N];
            int index = N - 1;
            boolean merged = false;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    if (index < N - 1 && newCol[index + 1] == arr[i][j] && !merged) {
                        newCol[index + 1] *= 2;
                        merged = true;
                    } else {
                        newCol[index--] = arr[i][j];
                        merged = false;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                arr[i][j] = newCol[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            String direction = info[1];
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }

            switch (direction) {
                case "up":
                    moveUp(arr);
                    break;
                case "down":
                    moveDown(arr);
                    break;
                case "left":
                    moveLeft(arr);
                    break;
                case "right":
                    moveRight(arr);
                    break;
            }

            System.out.println("#" + test_case );
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
