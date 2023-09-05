import java.util.*;

class Solution {
    public static int getCount(int n) {
        int count = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count + 1;
    }

    public int solution(int number, int limit, int power) {
        int result = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            list.add(getCount(i));
        }

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if (list.get(i) > limit) {
                result -= list.get(i) - power;
            }
        }

        return result;
    }
}