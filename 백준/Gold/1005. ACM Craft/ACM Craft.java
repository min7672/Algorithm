import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N,K,R;
    static int arrWeight[];
    static ArrayList<Integer> nodes[];
    static int nodeCnt[];
    static int []dpArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            
            StringTokenizer st= new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            arrWeight=new int[N];
            st= new StringTokenizer(br.readLine());
            nodes=new ArrayList[N];
            nodeCnt=new int[N];
            
            for(int i=0;i<N;i++){
                nodes[i]=new ArrayList<>();
                arrWeight[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<K;i++){
                st= new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                nodeCnt[b]++;
                nodes[a].add(b);
            }
            R=Integer.parseInt(br.readLine())-1;
         
            dpArr=new int[N];
            Queue<Integer> works=new LinkedList<>();
            for(int i=0;i<N;i++){
                dpArr[i]=arrWeight[i];
                if(nodeCnt[i]==0){              
                    works.add(i);
                }
            }
            
             while (!works.isEmpty()) {
                int cur=works.poll();
                
                for(int i=0;i<nodes[cur].size();i++){
                    int next=nodes[cur].get(i);
                    nodeCnt[next]--;
                    dpArr[next]=Math.max(dpArr[next],dpArr[cur]+arrWeight[next]);

                    if(nodeCnt[next]==0){
                        works.add(next);
                        
                        

                    }
                }
            }
            System.out.println(dpArr[R]);
            

        }
    }

}
