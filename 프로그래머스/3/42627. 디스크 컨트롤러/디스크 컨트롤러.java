import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        
        int idx = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        
        while(count < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }
            
            if(pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        
        return total / jobs.length;
    }
}