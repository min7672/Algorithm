import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Point> homes;  
    static int N, M;  
    static int[] costList;

    
    static int cost(int K) {
        if (costList[K] != 0) return costList[K];
        if (K == 0) return costList[0] = 1;
        return costList[K] = K * K + (K - 1) * (K - 1);
    }

    
    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    
    public static int calculateHomesInServiceArea(int x, int y, int K, int[][] cityMap) {
        int cnt = 0;
        
        for (Point home : homes) {
            if (Math.abs(home.x - x) + Math.abs(home.y - y) < K) {
                cnt++;
            }
        }
        return cnt;
    }

    
    public static int getMaxHomes(int[][] cityMap) {
        int result = 0;

        
        for (int K = 1; K <= N+1; K++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int homesInArea = calculateHomesInServiceArea(i, j, K, cityMap);
                    int totalCost = cost(K);
                    int income = homesInArea * M;
                    // 손해를 보지 않는 경우에만 최대로 많은 집을 선택
                    if (income >= totalCost) {
                        result = Math.max(result, homesInArea);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] cityMap = new int[N][N];
            homes = new ArrayList<>();

            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cityMap[i][j] = Integer.parseInt(st.nextToken());
                    if (cityMap[i][j] == 1) {
                        homes.add(new Point(i, j)); 
                    }
                }
            }

            
            costList = new int[22];  

            
            int result = getMaxHomes(cityMap);
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
