import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        ArrayList<Integer> list = new ArrayList<>();
        
        if (total % num == 0) {
            answer[num / 2] = total / num;
            for (int i = 0; i < num / 2; i++) {
                answer[i] = answer[num / 2] - num / 2 + i;
            }
            
            for(int i = num / 2 + 1; i < answer.length; i++) {
                answer[i] = answer[i - 1] + 1;
            }
        } else {
            answer[num / 2 - 1] = total / num;
            for(int i = 0; i < num / 2 - 1; i++) {
                answer[i] = answer[num / 2 - 1] - (num / 2 - 1) + i;
            }
            
            for(int i = num / 2; i < answer.length; i++) {
                answer[i] = answer[i - 1] + 1;
            }
        }
        
        return answer;
    }
}