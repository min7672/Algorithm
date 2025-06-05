import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        String []line=new String[2];
        int arr[][]=new int[N][2];
        for(int i=0;i<N; i++){
            line=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(line[0]);
            arr[i][1]=Integer.parseInt(line[1]);
        }
        int cnt=0;
        for(int i=0;i<N; i++){
            cnt=1;
            for(int j=0;j<N; j++){
                
                if(i!=j && arr[i][0]< arr[j][0] && arr[i][1]<arr[j][1]){
                    cnt++;
                }
                
            }
            bw.write(cnt+" ");
        }
        bw.flush();
            
    }
}