import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int arr[][];
    static int N;
    static Queue<Namu> works;
    static class Namu{
        public int x;
        public int y;
        public int state;
        public int depth;
        Namu(int x, int y, int state){
            this.x=x;
            this.y=y;
            this.state=state;
            this.depth=0;
        }
        Namu(int x, int y, int state,int depth){
            this.x=x;
            this.y=y;
            this.state=state;
            this.depth=depth;
        }
        public boolean checkUP(){
            
            if( this.state==1){
                if(x-2>=0 && arr[this.x-2][this.y]==0){
                    this.x=this.x-1;
                    return true;
                }
                return false;
            }else{
                boolean result=true;
                for(int i=this.y-1;i<this.y+2;i++){
                    if(this.x-1>=0 &&i>=0 &&i<N  && arr[this.x-1][i]==0)result=true;
                    else{
                        result=false;
                        break;
                    }
                }
                if(result){
                    this.x=this.x-1;
                    return true;
                }else{ 
                    return false;
                }
            }
        }
        public boolean checkDown(){
            if( this.state==1){
                if(this.x+2<N && arr[this.x+2][y]==0){
                    this.x=this.x+1;
                    return true;
                }else{
                    return false;
                }
                
            }else{
                boolean result=true;
                for(int i=this.y-1;i<this.y+2;i++){
                    if(this.x+1<N &&i>=0 &&i<N && arr[this.x+1][i]==0)result=true;
                    else{
                        result=false;
                        break;
                    }
                }
                if(result){
                    this.x=this.x+1;
                    return true;
                }else{
                    return false;
                }
            }
        }
        public boolean checkLeft(){
            if( this.state==1){
                boolean result=true;
                for(int i=this.x-1;i<this.x+2;i++){
                    if(this.y-1>=0 &&  i>=0 &&i<N&& arr[i][this.y-1]==0)result=true;
                    else{
                        result=false;
                        break;
                    }
                }
                if(result){
                    this.y=this.y-1;
                    return true;
                }else{
                    return false;
                }
                
                
            }else{
                if(this.y-2>=0 && arr[this.x][this.y-2]==0){
                    this.y=this.y-1;
                    return true;
                }else{
                    return false;
                }
            }
        }
        public boolean checkRight(){
            
            if( this.state==1){
                boolean result=true;
                
                for(int i=this.x-1;i<this.x+2;i++){
                    
                    if(this.y+1<=N-1 && i>=0 &&i<N&& arr[i][this.y+1]==0)result=true;
                    else{
                        result=false;
                        break;
                    }
                }
                if(result){
                    this.y=this.y+1;
                    return true;
                }else{
                    
                    return false;
                }  
             
            }else{
                if(this.y+2<=N-1 && arr[this.x][this.y+2]==0){
                    this.y=this.y+1;
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
        }
        public boolean chechTurn(){
            for(int i=this.x-1;i<this.x+2;i++){
                for(int j=this.y-1;j<this.y+2;j++){
                    
                    if(i<0 || j<0 || i>=N || j>=N)return false;

                    if(arr[i][j]==1)return false;
                }
            } 
            this.state=(this.state+1)%2;
            return true;
        }
        
    }
    /*중앙 나무*/
        /*세로 상태*/
            /* 1 : 세로 상태*/
        /*가로 상태*/
            /* 0 : 가로 상태*/
    /*움직 일 수 있는지?*/

    /* 도착지인지?*/
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        
        Namu startNamu=null;
        Namu endNamu=null;
        boolean visited[][][]=new boolean[N][N][3];
        for(int i=0;i<N;i++){
            char[] line=br.readLine().toCharArray();
            boolean stCh=false;
            boolean enCh=false;
            for(int j=0;j<N;j++){
                if(line[j]=='1'){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=0;
                }
                if(!stCh &&line[j]=='B' ){
                    if(j+1<N){
                        if(line[j+1]=='B'){
                            startNamu=new Namu(i, j+1, 0);
                        }
                    }
                    if(startNamu==null)startNamu=new Namu(i+1, j, 1);
                    stCh=true;
                }
                if(!enCh &&line[j]=='E' ){
                    if(j+1<N){
                        if(line[j+1]=='E'){
                            endNamu=new Namu(i, j+1, 0);
                        }
                    }
                    if(endNamu==null)endNamu=new Namu(i+1, j, 1);
                    enCh=true;
                }   
            }   
        }
    
        works=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        
        works.add(startNamu);
        visited[startNamu.x][startNamu.y][startNamu.state]=true;
        // System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // System.out.println(startNamu.x + ", "+ startNamu.y + " , "+ startNamu.state+ " , "+ startNamu.depth);
        // System.out.println(endNamu.x + ", "+ endNamu.y + " , "+ endNamu.state+ " , "+ endNamu.depth);
        // System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        while(!works.isEmpty()){
            Namu cur=works.poll();
            
            if(cur.x == endNamu.x && cur.y==endNamu.y && cur.state==endNamu.state){
                
                sb.append(cur.depth);
            }
            
            if(cur.x-1>=0&&!visited[cur.x-1][cur.y][cur.state]&&cur.checkUP()  ){
                // System.out.println("<"+cur.depth+">"+cur.state+ " 상태  위쪽으로 이동 ");
                // System.out.println(cur.x + ", "+ cur.y + " , "+ cur.state+ " , "+ cur.depth);
                visited[cur.x][cur.y][cur.state]=true;
                
                works.add(new Namu(cur.x, cur.y, cur.state, cur.depth+1));
                
                cur.x++;
            }
            if(cur.x+1<N &&!visited[cur.x+1][cur.y][cur.state]&&cur.checkDown() ){
                // System.out.println("<"+cur.depth+">"+cur.state+  " 상태  아래로 이동 ");
                // System.out.println(cur.x + ", "+ cur.y + " , "+ cur.state+ " , "+ cur.depth);
                visited[cur.x][cur.y][cur.state]=true;
                works.add(new Namu(cur.x, cur.y, cur.state, cur.depth+1));
                cur.x--;
            }
            
            if(cur.y-1>=0&& !visited[cur.x][cur.y-1][cur.state]&&cur.checkLeft()){
                // System.out.println("<"+cur.depth+">"+cur.state+ " 상태  좌로 이동 ");
                // System.out.println(cur.x + ", "+ cur.y + " , "+ cur.state+ " , "+ cur.depth);
                visited[cur.x][cur.y][cur.state]=true;
                works.add(new Namu(cur.x, cur.y, cur.state, cur.depth+1));
                cur.y++;
            }
            if(cur.y+1 <N&&!visited[cur.x][cur.y+1][cur.state]&&cur.checkRight()){
                // System.out.println("<"+cur.depth+">"+cur.state+ " 상태  우로 이동 ");
                // System.out.println(cur.x + ", "+ cur.y + " , "+ cur.state+ " , "+ cur.depth);
                visited[cur.x][cur.y][cur.state]=true;
                works.add(new Namu(cur.x, cur.y, cur.state, cur.depth+1));
                cur.y--;
            }
            
            if(!visited[cur.x][cur.y][(cur.state+1)%2]&& cur.chechTurn()){
                // System.out.println("<"+cur.depth+">"+cur.state+ " 상태로 회전 ");
                // System.out.println(cur.x + ", "+ cur.y + " , "+ cur.state+ " , "+ cur.depth);
                visited[cur.x][cur.y][cur.state]=true;
                works.add(new Namu(cur.x, cur.y, cur.state, cur.depth+1));
            }

        }
        if(sb.length()>0){
            System.out.println(sb);
        }else{ System.out.println(0);}

    }
}

