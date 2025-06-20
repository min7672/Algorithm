import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }
        int cnt=N;
        while(!queue.isEmpty()){
            if(cnt==1){
                System.out.println(queue.poll());
                break;
            }
            queue.poll();

            queue.add(queue.poll());
            cnt--;
        }
    }
}
