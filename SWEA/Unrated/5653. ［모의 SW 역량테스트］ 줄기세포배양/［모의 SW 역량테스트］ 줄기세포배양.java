import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static class Cell{
        public int x;
        public int y;
        public int life;
        public int baselife;
        Cell(int x,int y,int life){
            this.x=x;
            this.y=y;
            this.baselife=life;
            this.life=life;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        final int delta[][]={{1,0},{0,1},{0,-1},{-1,0}};

        int T=Integer.parseInt(br.readLine());

        for(int test_case=1;test_case<=T;test_case++){

            StringTokenizer st=new StringTokenizer(br.readLine());

            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());

            ArrayList<Cell> inactiveCells=new ArrayList<>();

            boolean arr[][]=new boolean[350][350];

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int a=Integer.parseInt(st.nextToken());
                    if(a!=0){
                        arr[150+i][150+j]=true;
                        inactiveCells.add(new Cell(150+i, 150+j,a ));
                    }
                }
            }

            ArrayList<Cell> activCells=new ArrayList<>();
            PriorityQueue<Cell> expandCells=new PriorityQueue<>(new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2){
                    return o2.baselife-o1.baselife;
                }
            });

            
            
            for(int i=0;i<K+1;i++){

                /*초기 상태 비활성 세포가 분열하기 때문에 활성 세포 먼저 처리 */
                
                expandCells.clear();
                for(int j=activCells.size()-1;j>=0;j--){
                    Cell cur=activCells.get(j);
                    cur.life--;
                    if(cur.life==0){
                        activCells.remove(j);
                    }
                }
                
                if(i==K)break;                 
                
                /*비활성 세포 라이프 소모 */
                for(int j=inactiveCells.size()-1;j>=0;j--){
                    Cell cur=inactiveCells.get(j);
                    
                    int tmpLife=cur.life--;
                    if(tmpLife==0){
                        
                        for(int k=0;k<4;k++){
                            int nx=cur.x+delta[k][0];
                            int ny=cur.y+delta[k][1];
                            if(!arr[nx][ny]){
                                expandCells.add(new Cell(nx,ny,cur.baselife));   
                            }
                        }
                        activCells.add(new Cell(cur.x, cur.y, cur.baselife));
                        inactiveCells.remove(j);
                    }
                }

                while (!expandCells.isEmpty()) {
                    Cell cur=expandCells.poll();
                    
                    if(!arr[cur.x][cur.y]){
                        arr[cur.x][cur.y]=true;
                        inactiveCells.add(new Cell(cur.x, cur.y, cur.baselife));
                    }
                }

                
            }
            System.out.printf("#%d %d\n",test_case,activCells.size()+inactiveCells.size());
            
            
            
        }

        
    }
}
