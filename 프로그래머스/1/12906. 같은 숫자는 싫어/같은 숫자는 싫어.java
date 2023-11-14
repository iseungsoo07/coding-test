import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        list.add(-1);
        int idx = 0;
		
        for(int i = 0; i < arr.length; i++) {
            if(list.get(idx) != arr[i]) {
                list.add(arr[i]);		
                idx++;
            }
        }

        int[] result = new int[list.size() - 1];
        
        for(int i = 1; i < list.size(); i++) {
            result[i - 1] = list.get(i);
        }
        
        return result;
    }
}
