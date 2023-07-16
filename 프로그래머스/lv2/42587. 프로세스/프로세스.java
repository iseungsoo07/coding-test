import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        LinkedList<Character> alpha = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int item : priorities) {
            queue.add(item);
        }

        for (int i = 0; i < queue.size(); i++) {
            alpha.add((char) (i + 65));
        }

        Character character = alpha.get(location);

        while (!queue.isEmpty()) {
            boolean isMax = true;
            int data = queue.poll();
            char ch = alpha.poll();
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i) > data) {
                    isMax = false;
                    queue.add(data);
                    alpha.add(ch);
                    break;
                }
            }

            if (!isMax) {
                continue;
            }

            if (character == ch) {
                break;
            } else {
                answer++;
            }
        }

        return answer;
    }
}