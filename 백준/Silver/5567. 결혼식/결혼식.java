import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node{
		public int x;
		public int depth;
		Node(int x, int depth){
			this.x=x;
			this.depth=depth;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String []line=new String[2];
		
		/*입력 변수 */
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		ArrayList<Integer> arr[]= new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=new ArrayList<>(); 
		}
		for(int i=0;i<M;i++) {
			line=br.readLine().split(" ");
			arr[Integer.parseInt(line[0])-1].add(Integer.parseInt(line[1])-1);
			arr[Integer.parseInt(line[1])-1].add(Integer.parseInt(line[0])-1);
		}
		
		/*bfs 변수*/
		Queue<Node> works=new LinkedList<Node>();
		boolean visited[]=new boolean[N];
		
		int result=0;
		works.add(new Node(0,0));
		visited[0]=true;
		while(!works.isEmpty()) {
			Node cur=works.poll();
			
			for(int i=0;i<arr[cur.x].size();i++) {
				int next= arr[cur.x].get(i);
				
				if(visited[next])continue;
				
				visited[next]=true;
				works.add(new Node(next,cur.depth+1));
				
				if(cur.depth+1<=2) result++;
					
								
			}/*노드 반복문 종료*/
		}/*bfs 종료*/
		
		System.out.println(result);
	}

}
