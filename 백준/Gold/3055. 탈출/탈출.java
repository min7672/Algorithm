import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] waterTime;  // 물이 해당 위치에 도달하는 시간
    static int[][] dTime;  // 고슴도치가 해당 위치에 도달하는 시간
    static boolean[][] visitedWater;  // 물이 확산된 곳을 기록
    static boolean[][] visitedD;  // 고슴도치가 방문한 곳을 기록

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        
        map = new char[R][C];
        waterTime = new int[R][C];
        dTime = new int[R][C];
        visitedWater = new boolean[R][C];
        visitedD = new boolean[R][C];

        Queue<Point> waterQueue = new ArrayDeque<>();
        Queue<Point> dQueue = new ArrayDeque<>();

        Point start = null, end = null;

        // 지도 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                waterTime[i][j] = Integer.MAX_VALUE;  // 물의 시간은 최대값으로 초기화
                dTime[i][j] = Integer.MAX_VALUE;  // 고슴도치의 시간도 최대값으로 초기화

                if (map[i][j] == 'S') {
                    start = new Point(i, j, 0);
                } else if (map[i][j] == 'D') {
                    end = new Point(i, j, 0);
                } else if (map[i][j] == '*') {
                    waterQueue.add(new Point(i, j, 0));  // 물의 시작 위치
                    waterTime[i][j] = 0;  // 물이 바로 차 있는 곳은 시간 0
                    visitedWater[i][j] = true;
                }
            }
        }

        // 물의 확산 BFS
        while (!waterQueue.isEmpty()) {
            Point cur = waterQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.' && !visitedWater[nx][ny]) {
                    visitedWater[nx][ny] = true;
                    waterTime[nx][ny] = cur.time + 1;
                    waterQueue.add(new Point(nx, ny, cur.time + 1));
                }
            }
        }

        // 고슴도치 이동 BFS
        dQueue.add(start);
        dTime[start.x][start.y] = 0;
        visitedD[start.x][start.y] = true;

        while (!dQueue.isEmpty()) {
            Point cur = dQueue.poll();

            // 목표 지점에 도달하면 그 즉시 결과 출력
            if (cur.x == end.x && cur.y == end.y) {
                System.out.println(cur.time);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visitedD[nx][ny] && map[nx][ny] != 'X') {
                    // 고슴도치가 이동할 수 있는 조건: 물이 먼저 차지 않았고, 돌이 아니어야 함
                    if (waterTime[nx][ny] > cur.time + 1) {
                        visitedD[nx][ny] = true;
                        dTime[nx][ny] = cur.time + 1;
                        dQueue.add(new Point(nx, ny, cur.time + 1));
                    }
                }
            }
        }

        // 고슴도치가 비버의 굴로 이동할 수 없다면 "KAKTUS" 출력
        System.out.println("KAKTUS");
    }
}
