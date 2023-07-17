import java.util.*;

class Solution {
    public int solution(int[] array) {

        Arrays.sort(array);
        int[] count = new int[array[array.length - 1] + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        int max = count[0];
        int result = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                result = i;
            } else if (count[i] == max) {
                max = count[i];
                result = -1;
            }
        }

        return result;
    }
}