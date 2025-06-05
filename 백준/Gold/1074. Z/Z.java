import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a, b; 
    static int result; 

    static void solution(int n, int startX, int startY, int visitCnt) {
        
        if (n == 1) {
            if (startX == a && startY == b) {
                result = visitCnt;
            }
            return;
        }

        
        int half = n / 2;

        
        if (a < startX + half && b < startY + half) { 
            solution(half, startX, startY, visitCnt);
        } else if (a < startX + half && b >= startY + half) { 
            solution(half, startX, startY + half, visitCnt + half * half);
        } else if (a >= startX + half && b < startY + half) { 
            solution(half, startX + half, startY, visitCnt + 2 * half * half);
        } else { // Bottom-right
            solution(half, startX + half, startY + half, visitCnt + 3 * half * half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        
        int n = Integer.parseInt(info[0]);
        a = Integer.parseInt(info[1]);
        b = Integer.parseInt(info[2]);

        
        n = (int) Math.pow(2, n);
        result = -1; 
        solution(n, 0, 0, 0);
        
        System.out.println(result); 
    }
}
