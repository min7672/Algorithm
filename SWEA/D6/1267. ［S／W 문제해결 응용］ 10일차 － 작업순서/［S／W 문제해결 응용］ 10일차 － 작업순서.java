import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case=1;test_case<=10;test_case++){
            String info[]=br.readLine().split(" ");
            int V=Integer.parseInt(info[0]);
            int E=Integer.parseInt(info[1]);
            ArrayList<Integer> nodes[]=new ArrayList[V];
            for(int i=0;i<V;i++){
                nodes[i]=new ArrayList<>();
            }
            int backCnt[]=new int[V];
            boolean visted[]=new boolean[V];

            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0 ;i<E*2;i=i+2){
                int a= Integer.parseInt(st.nextToken())-1;
                int b= Integer.parseInt(st.nextToken())-1;

                nodes[a].add(b);
                backCnt[b]++;
            }
            Queue<Integer> works=new LinkedList<>();
            for(int i=0;i<V;i++){
                if(backCnt[i]==0)works.add(i);
            }
            System.out.print("#"+test_case+" " );
            while(!works.isEmpty()){
                int curRow=works.poll();
                System.out.print((curRow+1)+" ");
                for(int i=0;i<nodes[curRow].size();i++){
                    int next=nodes[curRow].get(i);
                    // System.out.println(next+1);
                    if( visted[next])continue;
                    if(backCnt[next]>0) backCnt[next]--;
                    
                    
                    if(backCnt[next]==0){
                        visted[next]=true;
                        works.add(next);
                    }

                }
            }
            System.out.println("");
        }
    }
}