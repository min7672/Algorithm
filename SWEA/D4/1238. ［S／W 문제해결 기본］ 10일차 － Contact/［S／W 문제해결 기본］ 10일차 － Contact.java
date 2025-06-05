import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, S;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;

    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken()) - 1;  // 시작점 S (0-index로 변경)

            
            graph = new ArrayList[100];  
            for (int i = 0; i < 100; i++) {
                graph[i] = new ArrayList<>();
            }

            // 연락망 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                graph[from].add(to);
                
            }

            
            visited = new boolean[100];
            distance = new int[100];
            Arrays.fill(distance, -1);  

            // BFS 수행
            bfs(S);

            
            int maxTime = 0;
            for (int i = 0; i < 100; i++) {
                if (distance[i] > maxTime) {
                    maxTime = distance[i];
                }
            }

            
            int result = -1;
            for (int i = 0; i < 100; i++) {
                if (distance[i] == maxTime) {
                    result = Math.max(result, i + 1);  // 1-based index로 반환
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + result);
        }
    }
}
