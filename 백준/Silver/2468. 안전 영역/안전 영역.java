import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean tour[][];
	static boolean visited[][];
	static int delta[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	
	static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nextX=x+delta[i][0];
			int nextY=y+delta[i][1];
			
			if(nextX<0||nextY<0||nextX>=N||nextY>=N)continue;
			if(tour[nextX][nextY])continue;
			if(visited[nextX][nextY])continue;
			
			visited[nextX][nextY]=true;
			dfs(nextX,nextY);
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		String line[]=new String[N];
		int arr[][]=new int[N][N];
		int min_value=Integer.MAX_VALUE;
		int max_value=0;
		for(int i=0;i<N;i++) {
			line=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
				if( arr[i][j]<min_value)min_value=arr[i][j];
				if( arr[i][j]>max_value)max_value=arr[i][j];
			}
		}/*입력 끝*/
		int result=1;
		
		for(int i=min_value;i<=max_value;i++) {
			tour=new boolean[N][N];
			visited=new boolean[N][N];
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(arr[a][b]<=i) {
						tour[a][b]=true;
					}
				}
			}/*돌아 다닐 배열 초기화*/
			
			int ins_cnt=0;
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(!tour[a][b] && !visited[a][b]) {
						visited[a][b]=true;
						dfs(a,b);
						ins_cnt++;
					}
				}
			}/*돌아 다님*/
			if(ins_cnt>result)result=ins_cnt;
		}
		System.out.println(result);
	}

}
