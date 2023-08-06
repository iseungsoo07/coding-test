import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int len = rank.length;
        
        int[] selected = new int[3];
        int[] sorted_rank = new int[len];
        boolean[] sorted_attendance = new boolean[len];
        
        for(int i = 0; i < len; i++) {
            sorted_rank[rank[i] - 1] = rank[i];
            sorted_attendance[rank[i] - 1] = attendance[i];
        }
        
        int idx = 0;
        for(int i = 0; i < len; i++) {
            if(sorted_attendance[i]) {
                for(int j = 0; j < len; j++) {
                    if(rank[j] == i + 1) {
                        selected[idx++] = j;
                        break;
                    }
                }
                
                if(idx == 3) {
                    break;
                }
            }
        }
        
        return selected[0] * 10000 + selected[1] * 100 + selected[2];
    }
}