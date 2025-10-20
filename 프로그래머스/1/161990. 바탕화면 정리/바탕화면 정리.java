/*
코테준비, 프로그래머스 작성 코드 삭제 
파일 있는 칸 # 

파일 전체 선택 최소값

#위치 x, y

".#...",   (0, 1)
"..#..", 
"...#."    (3, 4)

*/
class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux=Integer.MAX_VALUE;
        int luy=Integer.MAX_VALUE;
        int rdx=0;
        int rdy=0;
        for(int i=0;i<wallpaper.length;i++){
            char row[]=wallpaper[i].toCharArray();
            
            for(int j=0;j<row.length;j++){
                if(row[j]=='#'){
                    lux=Math.min(lux, i);
                    luy=Math.min(luy, j);
                    rdx=Math.max(rdx,i);
                    rdy=Math.max(rdy,j);
                }
            }
        }
        System.out.println(lux + " , " + luy+ ", "+ (rdx+1)+" , "+ (rdy+1));
        int[] answer = {lux, luy, (rdx+1), (rdy+1)};
        return answer;
    }
}