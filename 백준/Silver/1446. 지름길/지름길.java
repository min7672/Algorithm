import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Spot {
        int to, cost;
        Spot(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int D = Integer.parseInt(st.nextToken()); 

        ArrayList<Spot>[] graph = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (to <= D) {
                graph[from].add(new Spot(to, cost));
            }
        }

        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i <= D; i++) {
            
            if (i > 0)
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);

            
            for (Spot s : graph[i]) {
                if (dist[s.to] > dist[i] + s.cost) {
                    dist[s.to] = dist[i] + s.cost;
                }
            }
        }

        System.out.println(dist[D]);
    }
}
