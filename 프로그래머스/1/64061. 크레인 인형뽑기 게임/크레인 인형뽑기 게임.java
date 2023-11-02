import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int top = -1;
        int count = 0;

        for(int i = 0 ; i < moves.length; i++) {
            if(!stack.isEmpty()) {
                top = stack.peek();
            }
            
            for(int j = 0; j < board[0].length; j++) {
                if(board[j][moves[i] - 1] != 0) {
                    if(board[j][moves[i] - 1] == top) {
                        count += 2;
                        stack.pop();
                        board[j][moves[i] - 1] = 0;
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                        board[j][moves[i] - 1] = 0;
                    }
                    
                    break;
                }
            } 
        }
        
        return count;
    }
}