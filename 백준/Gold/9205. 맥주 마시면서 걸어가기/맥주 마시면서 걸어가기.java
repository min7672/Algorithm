import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        public int x;
        public int y;
        
        Point(int x, int y){
            this.x=x;
            this.y=y;
            
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int test_case=1;test_case<=T; test_case++){
            int N=Integer.parseInt(br.readLine());
            ArrayList []nodes=new ArrayList[N+2];
            StringTokenizer st=null;
            ArrayList<Point> list=new ArrayList<>();
            for(int i=0;i<N+2;i++){
                st=new StringTokenizer(br.readLine());
                nodes[i]=new ArrayList<Integer>();
                list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            /*노드 100개, 100개 노드 탐색하면서 비용이 가까우면 연결 */
            for(int i=0;i<N+2;i++){
                Point base=list.get(i);
                for(int j=0;j<N+2 ; j++){
                    if(i!=j){
                        Point comp=list.get(j);
                        float cost=Math.abs(base.x-comp.x)+Math.abs(base.y-comp.y);
                        if(cost<=1000){
                            nodes[i].add(j);
                        }
                    }
                }
            }/*for문 끝*/

            
            boolean visited[]=new boolean[N+2];

            Queue<Integer> works=new ArrayDeque<>();
            works.add(0);
            visited[0]=true;
            boolean check=false;
            while(!works.isEmpty()){
                int curIdx=works.poll();
                if(curIdx==N+1){
                    check=true;
                    break;
                }
                // System.out.print(curIdx + " , next= [ ");
                for(int i=0;i<nodes[curIdx].size();i++){
                    int next=(int)nodes[curIdx].get(i);
                    // System.out.print(next+ ", ");
                    if(!visited[next]){
                        visited[next]=true;
                        works.add(next);
                    }
                }
                // System.out.print(" ] \n");

            }
            if(check)System.out.println("happy");
            else System.out.println("sad");
        }
               
    }
}