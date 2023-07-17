import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        String str = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if(!(ch >= 'a' && ch <= 'z')) {
                str += ch;
            }
        }
        
        String[] arr = str.split("");
        answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}