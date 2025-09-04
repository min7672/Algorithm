import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 
 * 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        st=  new StringTokenizer(br.readLine());
        int arr[]=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int sum = 0;
        int start = 0, end = 0;

        while (true) {
            if (sum >= M) {    //숫자가 이상이면 앞을 민다.
                if (sum == M) result++;
                sum -= arr[start++];
            } else if (end == N) {
                break;
            } else {    //숫자가 작으면 뒤를 민다.
                sum += arr[end++];
            }
        }

        System.out.println(result);

    }
}
