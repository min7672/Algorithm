import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] reflUpDown(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                _arr[R-1-r][c]=arr[r][c];
            }
        }

        return _arr;
    }
    static int[][] reflLeftRight(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[R][C];
        for(int c=0;c<C;c++){
            for(int r=0;r<R;r++){
                _arr[r][C-1-c]=arr[r][c];
            }
        }

        return _arr;
    }
    static int[][] right90(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[C][R];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                _arr[c][R-1-r]=arr[r][c];
            }
        }
        return _arr;
    }
    static int[][] left90(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[C][R];


        for(int r=0;r<R;r++){
            for(int c=C-1;c>=0;c--){
                _arr[C-1-c][r]=arr[r][c];
            }
        }
        
        return _arr;
    }
    static int[][] moveReClock(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[R][C];
        int delta[][]={{0,0},{0,C/2},{R/2,C/2},{R/2,0}};
        for(int i=0,j=3;i<4;i++,j=(j+1)%4){
            for(int x=0;x<=R/2-1;x++){
                for(int y=0;y<=C/2-1;y++){
                    _arr[delta[j][0]+x][delta[j][1]+y]=arr[delta[i][0]+x][delta[i][1]+y];
                    
                }   
            }
        }

        return _arr;
    }
        static int[][] moveClock(int arr[][]){
        int R=arr.length;
        int C=arr[0].length;
        int _arr[][]=new int[R][C];
        int delta[][]={{0,0},{0,C/2},{R/2,C/2},{R/2,0}};
        for(int i=0,j=1;i<4;i++,j=(j+1)%4){
            for(int x=0;x<=R/2-1;x++){
                for(int y=0;y<=C/2-1;y++){
                    _arr[delta[j][0]+x][delta[j][1]+y]=arr[delta[i][0]+x][delta[i][1]+y];
                    
                }   
            }
        }
        
        return _arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        int R=Integer.parseInt(info[2]);
        String []line=new String[M];
        int arr[][]=new int[N][M];
        int arr90[][]=new int[M][N];
        
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }
        String []rotateInfo=br.readLine().split(" ");
        int nums[]=new int[rotateInfo.length];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(rotateInfo[i]);
            if(nums[i]==3 || nums[i]==4){
                cnt++;
            }
        }
        boolean checker90=false;
        
        for(int j=0;j<nums.length;j++){
        
            switch (nums[j]) {
                case 1:
                    if(!checker90){
                        arr=reflUpDown(arr);
                    }else{
                        /*TRUE 처리부 */
                        arr90=reflUpDown(arr90);
                    }
                    break;
                case 2:
                    if(!checker90){
                        arr=reflLeftRight(arr);
                    }else{
                        /*TRUE 처리부 */
                        arr90=reflLeftRight(arr90);
                    }
                    break;
                case 3:
                    if(!checker90){
                        arr90=right90(arr);
                        checker90=true;
                    }else{
                        /*TRUE 처리부 */
                        arr=right90(arr90);
                        checker90=false;
                    }

                    break;
                case 4:
                    if(!checker90){

                        arr90=left90(arr);
                        checker90=true;
                    }else{
                        /*TRUE 처리부 */
                        arr=left90(arr90);
                        checker90=false;
                    }
                    break;
                case 5:
                    if(!checker90){
                        arr=moveClock(arr);
                    }else{
                        /*TRUE 처리부 */
                        arr90=moveClock(arr90);
                    }
                    break;
                case 6:
                    if(!checker90){
                        arr=moveReClock(arr);
                    }else{
                        /*TRUE 처리부 */
                        arr90=moveReClock(arr90);
                    }
                    break;

            }
        }
        
        if(cnt!=0){
            if(cnt%2==1){
                for(int i=0;i<M;i++){
                    for(int j=0;j<N;j++){
                        System.out.print(arr90[i][j]+" ");
                    }
                    System.out.println("");
                }
                
            }else{
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println("");
                }
            }
        
        }else{
            
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println("");
            }
        }
    }
}

