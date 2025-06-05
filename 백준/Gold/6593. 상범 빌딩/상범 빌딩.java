import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static class Point{
        public int l;
        public int r;
        public int c;
        
        public int depth;
        Point(int l, int r, int c, int depth){
            this.l=l;
            this.r=r;
            this.c=c;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String info[]=br.readLine().split(" ");
            if( info[0].equals("0"))break;
            int L=Integer.parseInt(info[0]);
            int R=Integer.parseInt(info[1]);        
            int C=Integer.parseInt(info[2]);
            char arr[][][]=new char[L][R][C];
            
            Point st=null;
            Point en=null;
            boolean visited[][][]=new boolean[L][R][C];
            for(int l=L-1;l>=0;l--){
                for(int r=0;r<R;r++){
                    arr[l][r]=br.readLine().toCharArray();
                    for(int c=0;c<C;c++){
                        if(arr[l][r][c]=='S'){
                            st=new Point( l,r, c, 0);
                            visited[l][r][c]=true;
                        }
                        if(arr[l][r][c]=='E')en=new Point( l, r,c, 0);
                    }
                }
                br.readLine();
            }
            
            Queue<Point> works=new ArrayDeque<>();
            int delta[][]={{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
            int result=1;
            works.add(st);
            boolean  checker =false;
            while(!works.isEmpty()){
                Point cur=works.poll();
                
                if(cur.l==en.l && cur.r ==en.r && cur.c==en.c){
                    result=cur.depth;
                    checker=true;
                    break;
                }

                for(int i=0;i<6;i++){
                    int nextL=cur.l+delta[i][0];
                    int nextR=cur.r+delta[i][1];
                    int nextC=cur.c+delta[i][2];


                    if((nextL<0|| nextR<0|| nextC<0|| nextL>=L||nextR>=R|| nextC>=C))continue;
                    
                    if(visited[nextL][nextR][nextC])continue;
                    
                    if(arr[nextL][nextR][nextC]=='.' ||arr[nextL][nextR][nextC]=='E'){
                        visited[nextL][nextR][nextC]=true;
                        works.add(new Point(nextL, nextR, nextC, cur.depth+1));
                        
                    }
                }
            }
            if(checker){
                System.out.printf("Escaped in %d minute(s).\n",result);
            }else System.out.println("Trapped!");
            
            
        }
    }

}
