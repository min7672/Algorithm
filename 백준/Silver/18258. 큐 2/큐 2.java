import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        StringTokenizer st=null;
        String mem="";
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            mem=st.nextToken();
            if(mem.equals("push")){
                mem=st.nextToken();
                deque.push(Integer.parseInt(mem));
            }else if(mem.equals("pop")){
                if(deque.isEmpty())bw.write("-1\n");
                else bw.write(deque.pollLast()+"\n");
            }else if(mem.equals("front")){
                if(deque.isEmpty())bw.write("-1\n");
                else bw.write(deque.peekLast()+"\n");
            }else if(mem.equals("back")){
                if(deque.isEmpty())bw.write("-1\n");
                else  bw.write(deque.peekFirst()+"\n");
            }else if(mem.equals("empty")){
                if(deque.isEmpty())bw.write("1\n");
                else bw.write("0\n");
            }else if(mem.equals("size")){
                bw.write(deque.size()+"\n");
            };
        }
        bw.flush();
        bw.close();
    }
}