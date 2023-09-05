import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int k, int m, int[] score) {
        score = IntStream.of(score)
            .boxed().sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue).toArray();
        
        int result = 0;

        for (int i = 0; i < score.length; i += m) {
            if (i + m > score.length) {
                break;
            }

            result += score[i + m - 1] * m;
        }

        return result;
    }
}