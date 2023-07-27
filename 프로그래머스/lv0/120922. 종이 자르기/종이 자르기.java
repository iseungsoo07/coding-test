class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        int col = Math.min(M, N);
        int row = Math.max(M, N);
        
        answer = (col - 1) + (row - 1) * col;
        
        return answer;
    }
}