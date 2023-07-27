import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        
        Deque<String> deque = new LinkedList<>();
        Deque<String> target = new LinkedList<>();
        String a = "";
        String b = "";
        
        for (String s : A.split("")){
            deque.addLast(s);
        }
        
        for (String s : B.split("")) {
            target.addLast(s);
        }
        
        for (int i = 0; i < A.length(); i++) {
            if (deque.equals(target)) {
                answer = i;
                break;
            } else {
                String s = deque.pollLast();
                deque.addFirst(s);
            }
        
        }
        
        return answer;
    }
}