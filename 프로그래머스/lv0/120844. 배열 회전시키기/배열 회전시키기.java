import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer> deque = new LinkedList<>();
        
        for(int item : numbers) {
            deque.addLast(item);
        }
        
        if("right".equals(direction)) {
            int data = deque.removeLast();
            deque.addFirst(data);
        } else if ("left".equals(direction)) {
            int data = deque.removeFirst();
            deque.addLast(data);
        }
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = deque.removeFirst();
        }
        
        return answer;
    }
}