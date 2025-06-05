import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long findSpot(long n){
        if(n<4)return 0;
        
        
        
        return (n * (n - 1) * (n - 2) * (n - 3)) / 24;
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader  br= new BufferedReader(new InputStreamReader(System.in)) ;
        int N= Integer.parseInt(br.readLine());
        System.out.println(findSpot(N));
    }
}