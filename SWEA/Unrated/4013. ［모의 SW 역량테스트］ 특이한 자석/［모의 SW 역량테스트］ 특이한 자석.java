import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static List<Integer> magnet[];

    
    static void solution(int num, int dir,int origin){       
        if(num==4|| num==-1 ) return;

        int curleft=magnet[num].get(6);;
        int curRight=magnet[num].get(2);
        
        if( dir==-1){
            /*반시계 회전 */
            int x=magnet[num].get(0);
            magnet[num].remove(0);
            magnet[num].add(x);
        }else{
            /*시계 */
            int x=magnet[num].get(7);
            magnet[num].remove(7);
            magnet[num].add(0, x);
        }
        if( num==origin){
            /*회전 값 */
            if(num>0){
                int leftMagnet=magnet[num-1].get(2);

                if(curleft!=leftMagnet)solution(num-1, 0-dir,origin);
            }
            if(num<=2){
                int rightMagnet=magnet[num+1].get(6);

                if(curRight!=rightMagnet)solution(num+1, 0-dir,origin);
            }
        }else if(num<origin){           
            /*전파 값 좌*/
            if(num>0){
                int leftMagnet=magnet[num-1].get(2);

                if(curleft!=leftMagnet)solution(num-1, 0-dir,origin);
            }
        }else if(num>origin){
            /*전파 값 우*/
            if(num<=2){
                int rightMagnet=magnet[num+1].get(6);
                
                if(curRight!=rightMagnet)solution(num+1, 0-dir,origin);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int K=Integer.parseInt(br.readLine());
            magnet=new List[4];
            StringTokenizer st;
            for(int i=0;i<4; i++){
                magnet[i]=new ArrayList<>();
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<8;j++){
                    magnet[i].add(Integer.parseInt(st.nextToken()));
                }
            }
            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int num=Integer.parseInt(st.nextToken())-1;
                int dir=Integer.parseInt(st.nextToken());
                
                solution(num, dir,num);
                
            }

            
            int sum=0;
            for(int i=0;i<4;i++){
                if(magnet[i].get(0)==1){
                    sum+=Math.pow(2, i);
                }
            }
            System.out.printf("#%d %d\n", test_case,sum);
        }
        
    }   
}
