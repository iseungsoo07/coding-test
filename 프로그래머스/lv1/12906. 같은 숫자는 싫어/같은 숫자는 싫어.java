import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int item : arr) {
            if(stack.isEmpty()) {
                stack.push(item);
            }
            
            if(stack.peek() != item) {
                stack.push(item);                    
            }
        }        
        
        return stack;
    }
}
