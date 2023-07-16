import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                count++;
            }
        }
        
        if(count == 0) {
            answer = new int[] {-1};
        } else {   
            answer = new int[count];
            
            int j = 0;
        
            for(int i = 0; i < count; i++) {
                for(; j < arr.length; j++) {
                   if(arr[j] % divisor == 0) {
                      answer[i] = arr[j++];
                      break;
                    }
                }
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}