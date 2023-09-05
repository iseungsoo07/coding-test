import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int numerator = 0;
            int denominator = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    numerator++;
                }

                if (stages[j] >= i) {
                    denominator++;
                }
            }
            if(denominator == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) numerator / denominator);
            }
        }

        int[] res = new int[N];
        int idx = 0;

        while (true) {
            if (map.size() == 0) {
                break;
            }

            double max = -1;
            int key = 0;

            for (Map.Entry<Integer, Double> item : map.entrySet()) {
                if (max < item.getValue()) {
                    max = item.getValue();
                    key = item.getKey();
                }
            }

            res[idx++] = key;
            map.remove(key);
        }

        return res;
    }
}