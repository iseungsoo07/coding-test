import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_width = -1;
        int max_height = -1;
        
        for(int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            max_width = Math.max(max_width, width);
            max_height = Math.max(max_height, height);
        }
        
        return max_width * max_height;
    }
}