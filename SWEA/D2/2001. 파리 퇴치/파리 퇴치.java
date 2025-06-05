import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int M= Integer.parseInt(info[1]);
            int arr[][]=new int[N][N];
            String tmp[]=new String[N];
            for(int i=0;i<N;i++){
                tmp=br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(tmp[j]);
                }
            }

            /*네모크기로 반복문 돌리기 */
            int maxResult = Integer.MIN_VALUE; 
            for (int row = 0; row <= N - M; row++) {
                for (int col = 0; col <= N - M; col++) {
                    int result = 0;
                    for (int i = row; i < row + M; i++) {
                        for (int j = col; j < col + M; j++) {
                            result += arr[i][j];
                        }
                    }
                    if (maxResult < result) {
                        maxResult = result;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,maxResult);

        }
    }
}
