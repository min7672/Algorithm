class Solution {
    public int solution(int n, int w, int num) {
        int rows = (n + w - 1) / w;
        int tr = (num - 1) / w;
        int pos = (num - 1) % w;

        
        int col = (tr % 2 == 0) ? pos : (w - 1 - pos);

        int count = 1;
        for (int r = tr + 1; r < rows; r++) {
            int len = Math.min(w, n - r * w);
            if (r % 2 == 0) {
                if (col < len) count++;
            } else {
                if (col >= w - len) count++;
            }
        }
        return count;
    }
}
