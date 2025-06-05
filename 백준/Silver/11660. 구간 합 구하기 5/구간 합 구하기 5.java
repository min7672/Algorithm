import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        String lineForN[]=new String[N];
        String lineForM[]=new String[M];
        int sum=0;
        int base[]=new int[N*N];
        for(int i=0;i<N;i++){
            lineForN=br.readLine().split(" ");
            
            for(int j=0;j<N;j++){
                sum+=Integer.parseInt(lineForN[j]);
                
                base[i*N+j]=sum;
                
            }   
        }
        
        
        int minusIdx=0;
        
        int sub1=0;
        int sub2=0;
        for(int i=0;i<M;i++){
            lineForM=br.readLine().split(" ");
            int x1=Integer.parseInt(lineForM[0])-1;
            int y1=Integer.parseInt(lineForM[1])-1;
            
            int x2=Integer.parseInt(lineForM[2])-1;
            int y2=Integer.parseInt(lineForM[3])-1;
            
            minusIdx=x1*N+y1-1;
            sub1=0;
            sub2=0;
            if(minusIdx>=0)sub1=base[minusIdx];

            /*
             * 앞쪽 반복해서 빼줄 값에 더해줌 
             * (x1, y1)-> (x2, y1)
            */
            // System.out.printf("(%d, %d), (%d, %d)\n",x1,y1, x2,y2);
            
            for(int j=x1+1;j<=x2;j++){
                sub2+=base[j*N+y1-1]-base[j*N-(N-y2)];
            }
            // System.out.println(base[x2*N+y2]);
            // System.out.println(sub1+" "+ sub2);
            System.out.println(base[x2*N+y2]-sub1-sub2);
        }
    }
}
