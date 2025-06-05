import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    static int arr[][];
    static int startPoint;
    static int preDirection;
                    /*좌 우 하 */
    static int delta[][]={{0,-1},{0,1},{-1,0}};
    static boolean exit;
    static int result;
    static int solution(int x,int y,int depth){
        if(exit)return 0;
        if(depth==0){
            exit=true;
            result=y;
            return y;
        }
        for(int i=0;i<3;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            if(i==0 &&preDirection==1 || i==1 &&preDirection==0)continue;
            if(nextX<100 && nextY >=0 && nextY<100 ){
                if(arr[nextX][nextY]==1){
                    preDirection=i;
                    // System.out.println(nextX+" "+nextY);
                    if(i==2)depth--;
                    solution(nextX, nextY,depth);
                }
                
                
            }
        }
        return 0;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for(int test_case=1;test_case<=10;test_case++){
            String T=br.readLine();
            arr=new int[100][100];
            
            startPoint=0;

            for(int i=0;i<100;i++){
                String []tmp=br.readLine().split(" ");
                for(int j=0;j<100;j++){
                    if(i!=99){ 
                        arr[i][j]=(int)tmp[j].charAt(0)-48;
                        continue;
                    }
                    
                    if(i==99 && tmp[j].equals("2")){
                        arr[i][j]=2;
                        startPoint=j;                  
                        
                    }
                }
            }  /*입력 끝 */
                exit=false;
                result=0;
                preDirection=2;
                solution(99,startPoint,99);
                System.out.printf("#%d %d\n", test_case,result);
                    
                
            
            
        }/*메인 끝 */ 
    }
}