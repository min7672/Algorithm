import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int nums[];
    static ArrayList<Integer> nodes[];
    static boolean visitedFcombi[];
    static boolean visitedLeft[];
    static boolean visitedRight[];
    static int min_Result;
    static void dsfLeft( int start ,ArrayList<Integer> district){
        for(int i=0;i<nodes[start].size();i++){
            int next=nodes[start].get(i);
            if(!visitedLeft[next] && district.contains(next)){
                visitedLeft[next]=true;
                dsfLeft(next,district);
            }
        }
    }
    static void dfsRight( int start,ArrayList<Integer> district ){
        for(int i=0;i<nodes[start].size();i++){
            int next=nodes[start].get(i);
            if(!visitedRight[next] && district.contains(next)){
                visitedRight[next]=true;
                dfsRight(next,district);
            }
        }
    }


    static void toDo9sum(){
        ArrayList<Integer> leftSide=new ArrayList<>();
        ArrayList<Integer> rightSide=new ArrayList<>();

        for(int i=0;i<N;i++){
            if(visitedFcombi[i]){
                leftSide.add(i);
            }else{
                rightSide.add(i);
            }
        }
        visitedLeft=new boolean[N];
        visitedRight=new boolean[N];
        /*dfs */
        if (leftSide.isEmpty() || rightSide.isEmpty()) return;
        
        visitedLeft[leftSide.get(0)]=true;
        dsfLeft(leftSide.get(0),leftSide);
        
        
        visitedRight[rightSide.get(0)]=true;
        dfsRight(rightSide.get(0),rightSide);
        
        int sumLeft=0;
        int sumRight=0;
        /*검사*/
        for(int i=0;i<leftSide.size();i++){
            if(!visitedLeft[leftSide.get(i)])return;
            sumLeft+=nums[leftSide.get(i)];
        }
        for(int i=0;i<rightSide.size();i++){
            if(!visitedRight[rightSide.get(i)])return;
            sumRight+=nums[rightSide.get(i)];
        }

        /*합계 */
        min_Result=Math.min(min_Result,(int)Math.abs(sumLeft-sumRight));

    }
    
    static void combi(int idx, int depth){
        if(depth>0 && depth<N){
            /*조합을 검사할 영역 */
            toDo9sum();
            
        }
        if(idx==N)return;

        visitedFcombi[idx]=true;
        combi(idx+1, depth+1);
        visitedFcombi[idx]=false;
        combi(idx+1, depth);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        String info[]=br.readLine().split(" ");
        nums=new int[N];
        nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(info[i]);
            nodes[i]=new ArrayList<>();
            String line[]=br.readLine().split(" ");
            for(int j=1;j<=Integer.parseInt(line[0]);j++){
                
                nodes[i].add(Integer.parseInt(line[j])-1);
            }
        }
        visitedFcombi=new boolean[N];
        min_Result=Integer.MAX_VALUE;
        combi(0,0);
        if(min_Result==Integer.MAX_VALUE)System.out.println("-1");
        else System.out.println(min_Result);

        
    }
}