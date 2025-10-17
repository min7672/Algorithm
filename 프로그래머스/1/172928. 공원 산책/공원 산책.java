/*
"방향 거리"

*/

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int r=park.length;
        int c=park[0].toCharArray().length;
        
        boolean parkB[][]=new boolean [r][c];
        
        int x=0;
        int y=0;
        for(int i=0;i<r;i++){
            char[] cPark=park[i].toCharArray();
            for(int j=0;j<c;j++){
                if(cPark[j]=='S'){
                    x=i;
                    y=j;
                }
                if(cPark[j]!='X'){
                    parkB[i][j]=true;
                }
            }
        }
        
        int delta[][]={{-1,0},{1,0}, {0,-1},{0,1}};
        
        for(int i=0;i<routes.length;i++){
            String tmp[]=routes[i].split(" ");
            int op=0;
            int n=Integer.parseInt(tmp[1]);
            
            if(tmp[0].equals("N"))op=0;
            if(tmp[0].equals("S"))op=1;
            if(tmp[0].equals("W"))op=2;
            if(tmp[0].equals("E"))op=3;
            
            int dx=x;
            int dy=y;
            int cnt=0;
            for(int d=0;d<n; d++){
                dx+=delta[op][0];
                dy+=delta[op][1];
                if(dx<0 || dy<0 ||dx>=r || dy>=c || !parkB[dx][dy]){
                    break;
                }
                cnt++;
                
            }
            if(cnt==n){
                x=dx;
                y=dy;
            }
           
            
            
        }
        answer[0]=x;
        answer[1]=y;
        return answer;
    }
}