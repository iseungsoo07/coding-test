import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            result[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        return result;
    }
}