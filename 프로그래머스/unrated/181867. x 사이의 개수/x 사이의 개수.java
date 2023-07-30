import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        
        if(myString.charAt(myString.length() - 1) == 'x') {
            myString += "0";
        }
        
        String[] arr = myString.split("x");
        System.out.println(Arrays.toString(arr));
        
        answer = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            if ("0".equals(arr[i])) {
                answer[i] = 0;
                continue;
            }
            answer[i] = arr[i].length();
        }
        
        return answer;
    }
}