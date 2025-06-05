import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String arrInfo[]=br.readLine().split(" ");
            int N=Integer.parseInt(arrInfo[0]);
            int M=Integer.parseInt(arrInfo[1]);
            String arr1[]=br.readLine().split(" ");
            int iarr1[]=new int[N];
            String arr2[]=br.readLine().split(" ");
            int iarr2[]=new int[M];
            int result=0;
            for(int i=0;i<N;i++){
                iarr1[i]=Integer.parseInt(arr1[i]);
            }
            for(int i=0;i<M;i++){
                iarr2[i]=Integer.parseInt(arr2[i]);
            }
            if(N>M){
                for(int i =0;i<=N-M;i++){
                    int innResult=0;
                    for(int j=0;j<M;j++){
                        innResult+=iarr1[j+i]*iarr2[j];
                    }
                    if(result<innResult){
                        result=innResult;
                    }                    
                }
            }else{
                for(int i =0;i<=M-N;i++){
                    int innResult=0;
                    for(int j=0;j<N;j++){
                        innResult+=iarr1[j]*iarr2[j+i];
                        
                    }
                    if(result<innResult){
                        result=innResult;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,result);
        }
    }
    
}
