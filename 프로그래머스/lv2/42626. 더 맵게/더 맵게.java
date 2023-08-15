import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int data : scoville) { 
            pq.add(data);
        }
        
        while(pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second * 2);
            answer++;
            
            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}