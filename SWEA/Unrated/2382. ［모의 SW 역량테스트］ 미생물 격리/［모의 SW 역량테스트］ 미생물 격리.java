import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static class MicroOrg implements Comparable<MicroOrg>{
        public int x;
        public int y;
        public int dir;
        public int num;
        MicroOrg(int x, int y, int dir, int num){
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.num=num;
        }
        @Override
        public int compareTo(MicroOrg o){
            return this.num-o.num;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        /* 상 좌 하 우 */
        int delta[][]={{-1,0,},{0,-1,},{1,0,},{0,1}};

        int T=Integer.parseInt(br.readLine());

        for(int test_case=1;test_case<=T;test_case++){
            String line[]=new String[4];
            line=br.readLine().split(" ");
            int N=Integer.parseInt(line[0]);
            int M=Integer.parseInt(line[1]);
            int K=Integer.parseInt(line[2]);
            
            
            ArrayList<MicroOrg> list=new ArrayList<>();

            for(int i=0;i<K;i++){
                line=br.readLine().split(" ");
                int a=Integer.parseInt(line[0]);
                int b=Integer.parseInt(line[1]);
                int c=Integer.parseInt(line[2]);
                int d=Integer.parseInt(line[3])-1;
                if(d==1)d=2;
                else if(d==2)d=1;
                list.add(new MicroOrg(a, b, d, c));
            }

            int sum=0;
            int arr[][]=new int[N][N];
            Queue<Integer> rmList=new ArrayDeque<>();
            list.sort(null);
            for(int i=0;i<M;i++){
                sum=0;
                arr=new int[N][N];
                rmList.clear();
                list.sort(null);
                // System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                for(int j=list.size()-1;j>=0;j--){
                    MicroOrg cur=list.get(j);
                    
                    /*미생물 이동*/
                    int nx=cur.x+delta[cur.dir][0];
                    int ny=cur.y+delta[cur.dir][1];

                    // System.out.println(j+" / "+nx + " , "+ ny + " / "+ cur.dir+ " | "+ cur.num);
                    if(nx == 0 ||nx == N-1 || ny == 0 || ny==N-1){
                        cur.num=Math.floorDiv(cur.num,2);
                        /*벽 반동 및 소멸 처리*/
                        if( cur.num==0){
                            rmList.add(j);
                            // System.out.print(j+ " ");
                        }
                        else{
                            cur.dir=(cur.dir+2)%4;
                            sum+=cur.num;
                            cur.x=nx;
                            cur.y=ny;
                        }

                    }else{/*처음 이동했을때 */
                        sum+=cur.num;
                        // System.out.println( arr[nx][ny] + " ");
                        if(arr[nx][ny]==0){
                            cur.x=nx;
                            cur.y=ny;
                            arr[nx][ny]=j;
                            
                        }else{/*이미 이동 했을때 */
                            MicroOrg tmp=list.get(arr[nx][ny]);
                            /*결합 처리*/
                            tmp.num+=cur.num;
                            rmList.add(j);
                            //System.out.print(j+ " ");
                        }
                    }
                }
                /*반동, 결합 미생물 제거*/
                while(!rmList.isEmpty()){
                    // int idx=rmList.peek();
                    // MicroOrg tmp=list.get(idx);
                    // System.out.println( tmp.x + " , "+ tmp.y + " , "+ tmp.dir+ " , "+ tmp.num);
                    list.remove((int)rmList.poll());
                }
            }
            System.out.printf("#%d %d\n", test_case,sum);
            
            
        }

    }
}