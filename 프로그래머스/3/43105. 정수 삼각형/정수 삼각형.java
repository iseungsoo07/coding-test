import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int size = triangle.length;        
        int[][] dp = new int[size + 1][size + 1];
        
        dp[1][1] = triangle[0][0];
        
        for (int i = 2; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) 
                    + triangle[i - 1][j - 1];
            }
        }
        
        answer = Arrays.stream(dp[size]).max().getAsInt();
        
        return answer;
    }
}