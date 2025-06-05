import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * n =1  1 
     * n =2  2  {1 , 1} {2}
     * n =3  4  {1, 1, 1}, {1, 2} , {2 ,1 }, {3}
     * n =4  7    {1, 1, 1, 1 }, {1,1, 2} , {1 ,2, 1 }, {2, 1, 1}, {2 , 2} {1, 3}, { 3, 1}
     * n = 5
     * 
     * n =7  44   
     * n =10 274
     */
    static int sol(int n){
        
        if(n==1 )return 1;
        if(n==2 )return 2;
        if(n==3 )return 4;
        return sol(n-1)+sol(n-2)+sol(n-3);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            System.out.println(sol(N));
        }
    }
}
