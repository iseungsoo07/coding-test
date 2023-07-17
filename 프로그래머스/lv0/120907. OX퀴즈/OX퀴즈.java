import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        
        String[] result = new String[quiz.length];

        for(int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            int num3 = Integer.parseInt(parts[4]);
            
            if(parts[1].equals("-")) {
                int answer = num1 - num2;
                if(answer == num3) {
                    result[i] = "O";
                } else {
                    result[i] = "X";
                }
            } else if (parts[1].equals("+")){
                int answer = num1 + num2;
                if(answer == num3) {
                    result[i] = "O";
                } else {
                    result[i] = "X";
                }
            }
        }
        
        return result;
    }
}