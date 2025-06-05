import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
	
	static int v, e;
	static boolean[] visit;
	static int[] graph;
	static StringBuilder sb;
	static ArrayList<Integer> nodes[];
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	v = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	graph = new int[v + 1];
        	visit = new boolean[v + 1];

        	nodes=new ArrayList[v+1];
			for(int i=0;i<=v;i++)nodes[i]=new ArrayList<>();

        	for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
				nodes[a].add(b);
        		graph[b]++;
        	}
        	
        	
        	for (int i = 1; i <= v; i++) {
        		if (check(i) && !visit[i]) {
        			dfs(i);
        		}
        	}
            
         
        System.out.println(sb);
    }
    
    static void dfs(int a) {
		sb.append(a).append(" ");
		visit[a] = true;
		
		// 다음으로 이동할 점을 찾음
    	for (int k = 0; k < nodes[a].size(); k++) {
			int i=nodes[a].get(k);
    		// 현재 점과 이어져 있을 경우 간선을 제거
			if (graph[i] > 0) {  
				--graph[i];
				// 다음으로 이동할 점에 이어진 간선이 없다면 이동
				if (check(i)) {
					dfs(i);
				}
			}
		}
    }
    
    // 현재 점으로 이어진 간선이 존재하는지 확인
    static boolean check(int a) {
    	for (int i = 1; i <= v; i++) {
			
    		if (graph[a] != 0 && !visit[a]) {
    			return false;
    		}
    	}
    	return true;
    }
}
