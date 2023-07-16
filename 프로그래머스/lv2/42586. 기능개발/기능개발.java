import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i = 0 ; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100F - progresses[i]) / speeds[i]);
        }
        
        int count = 1;
        int target = days[0];
        
        for(int i = 1; i < days.length; i++) {
            if(target < days[i]) {
                target = days[i];
                list.add(count);
                count = 1;
            }  else {
                count++;
            }
        }
        
        list.add(count);
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}