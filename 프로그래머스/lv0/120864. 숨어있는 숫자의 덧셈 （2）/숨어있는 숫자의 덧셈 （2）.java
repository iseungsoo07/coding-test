import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String num = "";
        Queue<Character> queue = new LinkedList<>();
        for (char c : my_string.toCharArray()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            while (queue.element() >= '0' 
                   && queue.element() <= '9') {
                num += queue.poll();
                if (queue.isEmpty()) {
                    break;
                }
            }

            queue.poll();
            if (!num.equals("")) {
                answer += Integer.parseInt(num);
                num = "";
            }
        }

        return answer;
    }
}