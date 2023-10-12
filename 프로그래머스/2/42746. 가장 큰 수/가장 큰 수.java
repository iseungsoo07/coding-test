import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        Arrays.stream(numbers).boxed()
            .sorted((x, y) -> {
                int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
                int b = Integer.parseInt(String.valueOf(y) + String.valueOf(x));
                
                return b - a;
            }).forEach(x -> sb.append(x));
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}