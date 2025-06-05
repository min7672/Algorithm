import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static char arr[];
    static boolean visited[];
    static ArrayList<Character> result;
    static StringBuilder sb;
    static void combi(int idx ,int start){
        if(idx==L){
            int mCnt=0;
            int jCnt=0;
            for(int i=0;i<C;i++){
                if(visited[i]){
                    if("aeiou".indexOf(arr[i])>=0)mCnt++;
                    else jCnt++;
                }  
            }
            if( mCnt>=1 && jCnt>=2){System.out.println(sb);}
            
            return;
        }
        for(int i=start;i<C;i++){
            if(visited[i])continue;
            visited[i]=true;
            sb.append(arr[i]);
            combi(idx+1,i);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
        
        
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new char[C];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            arr[i]=st.nextToken().charAt(0);
        }
        visited=new boolean[C];
        sb=new StringBuilder();
        Arrays.sort(arr);
        combi(0,0);
    }
}
