import java.util.*;

class Solution {
    
    public static int countDiv(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public int[] solution(int n) {
        int[] div = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        int count = countDiv(n);
        
        div = new int[count];
        int idx = 0;
        
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                div[idx++] = i;
            }
        }
        
        for(int i = 0; i < div.length; i++) {
            if(countDiv(div[i]) == 2) {
                list.add(div[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}