import java.util.*;
import java.util.stream.*;

class Solution {
    final static int[] rank = {6, 6, 5, 4, 3, 2, 1};
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;

        List<Integer> lottoList = Arrays.stream(lottos)
            .boxed().collect(Collectors.toList());
        
        List<Integer> winNumList = Arrays.stream(win_nums)
            .boxed().collect(Collectors.toList());

        for (int i = 0; i < winNumList.size(); i++) {
            if (lottoList.contains(winNumList.get(i))) {
                count++;
            }
        }

        answer[1] = rank[count];

        for (int i = 0; i < lottoList.size(); i++) {
            if (lottoList.get(i) == 0) {
                count++;
            }
        }

        answer[0] = rank[count];

        return answer;
    }
}