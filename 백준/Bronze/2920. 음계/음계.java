import java.util.Scanner;

public class Main{ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums[] = sc.nextLine().split(" ");
        
        int pre = Integer.parseInt(nums[0]);
        int chck = 0;
        
        // Ascending check
        if (pre == 1) {
            chck = 1;
            for (int i = 1; i < 8; i++) {
                int cur = Integer.parseInt(nums[i]);
                if (cur == pre + 1) {
                    pre = cur;
                } else {
                    chck = 0;
                    break;
                }
            }
        }
        
        // Descending check
        else if (pre == 8) {
            chck = 2;
            for (int i = 1; i < 8; i++) {
                int cur = Integer.parseInt(nums[i]);
                if (cur == pre - 1) {
                    pre = cur;
                } else {
                    chck = 0;
                    break;
                }
            }
        } 
        // Mixed check if not ascending or descending
        else {
            chck = 0;
        }
        
        if (chck == 0) {
            System.out.println("mixed");
        } else if (chck == 1) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
