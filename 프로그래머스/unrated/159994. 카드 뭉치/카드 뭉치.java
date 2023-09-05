import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> list1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> list2 = Arrays.asList(cards2);

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            if (list1.contains(goal[i])) {
                if (!goal[i].equals(list1.get(idx1++))) {
                    return "No";
                }
            } else if (list2.contains(goal[i])) {
                if (!goal[i].equals(list2.get(idx2++))) {
                    return "No";
                }
            }
        }

        return "Yes";
    }
}