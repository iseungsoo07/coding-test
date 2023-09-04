import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (x, y) -> {
            if (x.charAt(n) == y.charAt(n)) {
                return x.compareTo(y);
            }
            return x.charAt(n) - y.charAt(n);
        });

        return strings;
    }
}