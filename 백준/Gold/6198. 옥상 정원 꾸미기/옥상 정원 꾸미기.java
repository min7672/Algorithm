/*
 i번째 빌딩 키 hi, 일렬 오른쪽 봄
i >> i+1, i+2,i+3 ... 같은키 못봄

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Long result=Long.valueOf(0);
        for(int i=0;i<N;i++){
            int base=arr[i];
            int cnt=0;
            for(int j=i+1;j<N;j++){
                if(base>arr[j])cnt++;
                else {
                    break;
                }
            }
            result+=cnt;
        }
        System.out.println(result);
    }
    
}