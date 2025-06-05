import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String []line=new String[2];
        Deque<Integer> queue=new LinkedList();
        for(int i=0;i<N; i++){
            line=br.readLine().split(" ");
            if( line[0].equals("push")){
                queue.add(Integer.parseInt(line[1]));
            }else if( line[0].equals("pop")){
                if(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }else{
                    System.out.println(-1);
                }
            }else if( line[0].equals("front")){
                if(!queue.isEmpty()){
                    System.out.println(queue.peek());
                }else{
                    System.out.println(-1);
                }
            }else if( line[0].equals("back")){
                if(!queue.isEmpty()){
                    System.out.println(queue.peekLast());
                }else{
                    System.out.println(-1);
                }
            }else if( line[0].equals("size")){
                System.out.println(queue.size());
            }else if( line[0].equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }



        }
    }
}