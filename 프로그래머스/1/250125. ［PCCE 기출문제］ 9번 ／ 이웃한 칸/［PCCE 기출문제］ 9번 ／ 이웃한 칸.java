/*
색칠 2차원 격자, 4방 같은색 칸 개수 

*/

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String center=board[h][w];
        int n=board.length;
        int m=board[0].length;
        int delta[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<4;i++){
            int nx=delta[i][0]+h;
            int ny=delta[i][1]+w;
            if(nx<0 || ny<0 || nx>=n ||ny>=m)continue;
            if(center.equals(board[nx][ny]))answer++;
        }
        return answer;
    }
}