import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> nums = new ArrayList<>();
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                if (c == '1') {
                    if (dartResult.charAt(i + 1) == '0') {
                        nums.add(10);
                        i++;
                        idx++;
                        continue;
                    }
                }
                nums.add(Character.getNumericValue(c));
                idx++;
                continue;
            }

            if (c == 'D') {
                nums.set(idx, nums.get(idx) * nums.get(idx));
            } else if (c == 'T') {
                nums.set(idx, nums.get(idx) * nums.get(idx) * nums.get(idx));
            } else if (c == '*') {
                if (idx == 0) {
                    nums.set(idx, nums.get(idx) * 2);
                } else {
                    nums.set(idx, nums.get(idx) * 2);
                    nums.set(idx - 1, nums.get(idx - 1) * 2);
                }
            } else if (c == '#') {
                nums.set(idx, nums.get(idx) * -1);
            }
        }

        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}