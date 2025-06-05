import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int distance [][];
    static boolean visit [][];
    
    static class node implements Comparable<node> {
        int r,c,weight;

        public node(int r, int c, int weight) {
            super();
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(node o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }
        
        
        
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
        
        N = Integer.parseInt(br.readLine().trim());
        
        if(N==0) break;
        
        
        map = new int[N][N];
        
        StringTokenizer st;
        
        
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dijskra();
        sb.append("Problem ").append(count).append(": ").append(distance[N-1][N-1]).append('\n');
        count++;        
        }
        System.out.println(sb.toString());

    }
    
    public static void dijskra() {
        
        distance = new int[N][N];
        visit = new boolean[N][N];
        
        for(int [] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }        
        distance[0][0] = map[0][0];
        
        PriorityQueue<node> pq = new PriorityQueue<node>();
        pq.offer(new node(0, 0 , map[0][0]));
        
        while(!pq.isEmpty()) {
            
            node n = pq.poll();
            
            int row = n.r;
            int col = n.c;
            int w = n.weight;
            
           
            
            for(int d=0; d<4; d++) {
                int nr = row+ dr[d];
                int nc = col+ dc[d];
                
                if(nr >=0 && nr < N && nc >=0 && nc < N) {
                    if(distance[nr][nc] > w + map[nr][nc]) {
                        distance[nr][nc] =w + map[nr][nc];
                        pq.offer(new node(nr,nc,w + map[nr][nc]));
                        
                    }
                }
                
            }
            
            
            
        }
        
        
    }
    
}