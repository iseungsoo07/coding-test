import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);

            res.add(list.get(commands[i][2] - 1));
            list.clear();
        }

        int[] answer = new int[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}