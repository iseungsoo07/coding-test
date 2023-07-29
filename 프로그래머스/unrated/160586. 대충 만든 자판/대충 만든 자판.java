import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                String s = String.valueOf(keymap[i].charAt(j));
                if(map.get(s) == null) {
                    map.put(s, j + 1);
                } else {
                    if(map.get(s) > j + 1) {
                        map.put(s, j + 1);
                    }
                }
            }
        }
        
        System.out.println(map);
        
        
        int count = 0;
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if(map.get(String.valueOf(targets[i].charAt(j))) == null) {
                    count = -1;
                    break;
                }
                
                count += map.get(String.valueOf(targets[i].charAt(j)));
            }
            answer[i] = count;
            count = 0;
        }
        
        
        return answer;
    }
}