import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int size = (int) Math.ceil((double) my_str.length() / n);
        String[] answer = new String[size];

        for (int i = 0; i < answer.length; i++) {
            if (my_str.length() < n) {
                answer[i] = my_str;
                break;
            } else {
                answer[i] = my_str.substring(0, n);
            }
            my_str = my_str.substring(n);
        }

        return answer;
    }
}