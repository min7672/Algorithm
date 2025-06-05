import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static int N;
    static boolean visited[];
    static StringBuilder sb;
    static int cnt;
    static HashMap<Integer, ArrayList<Integer>> map ;
    static void combi(int idx){
        if(sb.length()>0){
            for(int i=0; i<N;i++){
                if(visited[i]){
                    ArrayList<Integer> values=map.get(i);
                    if(values!=null){
                        for(int j=0;j<values.size();j++){
                            // System.out.println(">>>>"+i+" "+ values.get(j));
                            if(visited[values.get(j)])return;
                        }
                    }
                }
            }
            
            // System.out.println("조합입니다" +": "+sb);
            cnt++;
        }
            

        for(int i=idx;i<=N;i++){
            sb.append(i);
            visited[i]=true;
            combi(i+1);
            visited[i]=false;
            sb.deleteCharAt(sb.length()-1);
            
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        String []tmpInfo=new String[2];
        
        for(int test_case=1;test_case<=T;test_case++){
            tmpInfo=sc.nextLine().split(" ");
            N=Integer.parseInt(tmpInfo[0]);
            int M=Integer.parseInt(tmpInfo[1]);
            visited=new boolean[N+1];
            sb=new StringBuilder();
            map = new HashMap<Integer, ArrayList<Integer>>();

            for(int i=0;i<M;i++){
                tmpInfo=sc.nextLine().split(" ");
                int key=Integer.parseInt(tmpInfo[0]);
                int value=Integer.parseInt(tmpInfo[1]);
                if(key>value){
                    int tmp=value;
                    value=key;
                    key=tmp;
                }
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                // if(map.get(key)==null){
                //     ArrayList<Integer> tmp=new ArrayList<>();
                //     tmp.add(value);    
                //     map.put(key,tmp);
                // }else{
                //     map.get(key).add(value);
                // }
            }
            cnt=0;
            combi(1);
            System.out.printf("#%d %d\n",test_case,cnt+1);

            

        }
    }   
}
