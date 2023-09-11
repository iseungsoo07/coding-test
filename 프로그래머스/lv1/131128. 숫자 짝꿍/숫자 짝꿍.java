import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] x_nums = new int[10];
        int[] y_nums = new int[10];
        
        List<Integer> list = new ArrayList<>();
        
        for(char c : X.toCharArray()) {
            x_nums[c - '0']++;
        }
        
        for(char c : Y.toCharArray()) {
            y_nums[c - '0']++;
        }
        
        for(int i = 0; i < 10; i++) {
            while(x_nums[i] > 0 && y_nums[i] > 0) {
                list.add(i);
                
                x_nums[i]--;
                y_nums[i]--;
            }
        }
        
        if(list.size() == 0) {
            return "-1";
        }
               
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(int data : list) {
            sb.append(data);
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}