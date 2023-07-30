import java.util.*;

class Solution {
    
    public static void getPrevious(Stack<Integer> stack, String recipe) {
        stack.push(Integer.parseInt(recipe.charAt(3) + ""));
        stack.push(Integer.parseInt(recipe.charAt(2) + ""));
        stack.push(Integer.parseInt(recipe.charAt(1) + ""));
        stack.push(Integer.parseInt(recipe.charAt(0) + ""));
    }
    
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        String recipe = "";
        for(int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            if(stack.size() >= 4) {
                for(int j = 0; j < 4; j++) {
                    recipe += stack.pop();
                }
                if("1321".equals(recipe)){
                    answer++;
                    recipe = "";
                } else {
                    getPrevious(stack, recipe);
                    recipe = "";
                }
            }
        }
        return answer;
    }
}