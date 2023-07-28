import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int sequence = 0;
        for(String name : players) {
            map.put(name, sequence++);
        }
        
        for(String name : callings) {
            sequence = map.get(name); // 4
            String before = players[sequence - 1];
            
            players[sequence - 1] = name;
            players[sequence] = before;
            
            map.put(name, sequence - 1);
            map.put(before, sequence);
        }
        
        return players;
    }
}