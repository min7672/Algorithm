import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char []arr= br.readLine().toCharArray();
        //m = 10 - (a+3b+c+3d+e+3f+g+3h+i+3j+k+3l) mod 10
        
        int weight=1;
        int m=(int)arr[arr.length-1]-48;
        int result=0;
        for(int i=0;i<10;i++){
            int sum=0;
            for(int j=0;j<arr.length-1;j++){
                int x=(arr[j]=='*')? i: (int)arr[j]-48;
                if(j%2==0){
                    weight=1;
                }else{
                    weight=3;
                }
                sum += weight*x;
            }
            int tmp=(10-(sum%10))%10;
            if(m==tmp){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }   
}