/*
x , n (1~9) - 식량

2차원 배열 전체 탐색 
- 발견(visited==false)-> BFS (max)

[
"X591X",
"X1X5X"
"X231X" 
"1XXX1"

*/
import java.util.*;

class Solution {
    static public class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int n=maps.length;
        int m=maps[0].length();
        int arr[][]=new int[n][m];
        
        boolean visited[][]=new boolean[n][m];
        Queue<Point> queue=new ArrayDeque<>();
        /*탐색에 용이한 형태로 변경*/
        for(int i=0;i<n;i++){
            char tmp[]=maps[i].toCharArray();
            for(int j=0;j<m; j++){
                if(tmp[j]=='X'){
                    arr[i][j]=-1;
                }else{
                    arr[i][j]=Integer.parseInt(tmp[j]+"");
                }
            }
        }
        
        int delta[][]={{1,0},{0,1},{-1,0},{0,-1}};
        /*2차원 탐색*/
        for(int i=0;i<n;i++){
            for(int j=0;j<m; j++){
                if(arr[i][j]!=-1 && !visited[i][j]){
                    int ins_sum=0;
                    visited[i][j]=true;
                    // System.out.println( i + " , " + j);
                    queue.add(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point cur=queue.poll();
                        ins_sum+=arr[cur.x][cur.y];
                        
                        for(int k=0;k<4;k++){
                            int nx=cur.x+delta[k][0];
                            int ny=cur.y+delta[k][1];
                            if(nx>=0&&ny>=0 && nx<n&&ny<m && !visited[nx][ny] && arr[nx][ny]!=-1){
                                queue.add(new Point(nx,ny));
                                visited[nx][ny]=true;
                            }
                        }
                    }
                    answer.add(ins_sum);
   
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        if(answer.size()==0){
            int []ans={-1};
            return ans;
        }else{
            /*반환값 통일 */
            int []ans=new int[answer.size()];
            for(int i=0;i<ans.length;i++){
                ans[i]=answer.get(i);
            }
            return ans;            
        }
        
    }
}