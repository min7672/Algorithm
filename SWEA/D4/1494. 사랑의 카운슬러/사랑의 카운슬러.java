import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int N;
    static ArrayList<Point> worms;
    static boolean visited[];
    static long result;

    static void combi(int cnt, int start){
        // System.out.println(idx);
        if(N/2==cnt){
            
            long dx=0,dy=0;
            for(int i=0;i<N;i++){

                if(visited[i]){
                    dx+=worms.get(i).x;
                    dy+=worms.get(i).y;
                }else{
                    dx-=worms.get(i).x;
                    dy-=worms.get(i).y;
                }
            }
            long vectorSize=(dx*dx)+(dy*dy);
            result = (result > vectorSize) ? vectorSize : result;
            return;
        }
        for(int i=start;i<N; i++){
            visited[i]=true;
            combi(cnt+1, i+1);
            visited[i]=false;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
            for(int test_case=1;test_case<=T;test_case++){

            
            N=Integer.parseInt(br.readLine());
            worms=new ArrayList<>();
            StringTokenizer st=null;
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                worms.add(new Point(a, b));
            }
            visited=new boolean[N];
            result=Long.MAX_VALUE;
            combi(0,0);
                    
            System.out.printf("#%d %d\n",test_case,result);
        }
    }
}
