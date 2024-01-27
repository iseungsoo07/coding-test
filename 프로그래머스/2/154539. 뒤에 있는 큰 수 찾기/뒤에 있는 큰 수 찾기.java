import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numbers.length];
        
        Arrays.fill(result, -1);
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            int cur = numbers[i];
            while(!stack.isEmpty()) {
               if(stack.peek() > cur) {
                   result[i] = stack.peek();
                   break;
               }
                
                stack.pop();  
            }
            
            stack.push(cur);
        }
        
        return result;
    }
}