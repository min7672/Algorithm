import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int arr[]=new int[N];
        ArrayList<Integer> nums=new ArrayList<>();
        int sum=0;
        int result=0;
        for(int i=0;i<N;i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        nums.sort(null);
        for(int i=0;i<N;i++){
            sum+=nums.get(i);
            arr[i]=sum;
            result+=arr[i];
        }
        System.out.println(result);


    }
}
