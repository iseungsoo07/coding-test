import java.util.*;

class Solution {
    final static int[] no1 = {1, 2, 3, 4, 5};
    final static int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
    final static int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
    
    public int[] solution(int[] answers) {
      int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (no1[i % no1.length] == answers[i]) {
                score[0]++;
            }

            if (no2[i % no2.length] == answers[i]) {
                score[1]++;
            }

            if (no3[i % no3.length] == answers[i]) {
                score[2]++;
            }
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray(); 
    }
}