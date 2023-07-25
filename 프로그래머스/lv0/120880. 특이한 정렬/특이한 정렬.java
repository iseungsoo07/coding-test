import java.util.*;

class Solution {
    
    public static boolean visitAll(boolean[] visited) {
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        boolean[] visited = new boolean[numlist.length];
        int[] diff = new int[numlist.length];
        Arrays.sort(numlist);
        
        for(int i = 0; i < numlist.length; i++) {
            diff[i] = Math.abs(numlist[i] - n);
        }
        
        int pos = 0;
        while(!visitAll(visited)) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            
            for(int i = 0; i < diff.length; i++) {
                if(diff[i] <= min && !visited[i]) {
                    min = diff[i];
                    idx = i;
                }
            }
            
            visited[idx] = true;
            answer[pos++] = numlist[idx];
            
        }
        
        
        
        return answer;
    }
}