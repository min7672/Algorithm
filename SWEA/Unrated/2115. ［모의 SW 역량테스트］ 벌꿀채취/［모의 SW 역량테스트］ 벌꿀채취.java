import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int calValue(int arr[],int c){
        int n=arr.length;
        int result=0;
        for(int mask=0; mask<(1<<n);mask++){
            int sum=0;
            int powSum=0;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    powSum+=Math.pow(arr[i], 2);
                    sum+=arr[i];
                }
            }
            if(sum<=c && result<powSum)result=powSum;
        }
        return result;
    }

    static class Point{
        public int x;
        public int y;
        public int cal;
        Point(int x, int y, int cal){
            this.x=x;
            this.y=y;
            this.cal=cal;
        }
    }
    static boolean check(Point a,Point b,int m){
        if(a.x!=b.x)return true;
        else{
            if(a.y>b.y){
              if(b.y+m<=a.y){
                return true;
              }else return false;
            }else{
                if(a.y+m<=b.y){
                return true;
                }else return false;
                
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int C=Integer.parseInt(st.nextToken());
            int arr[][]=new int[N][N];
            int calArr[][]=new int[N][N-M+1];

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            ArrayList<Point> calList=new ArrayList();
            
            for(int i=0;i<N;i++){
                for(int j=0;j<=N-M;j++){
                    int curList[]=new int[M];
                    for(int k=j,l=0;k<j+M;l++,k++){
                        curList[l]=arr[i][k];
                    }
                    calList.add(new Point(i,j,calValue(curList,C)));
                }
            }
            calList.sort(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2){
                    return o2.cal-o1.cal;
                }
            });
            Point top=calList.get(0);
            Point top2=null;
            for(int i=1;i<calList.size();i++){
                if(check(top,calList.get(i),M)){
                    top2=calList.get(i);
                    break;
                }
            }   
            System.out.printf("#%d %d\n",test_case,top.cal+top2.cal);
        }

    }
}