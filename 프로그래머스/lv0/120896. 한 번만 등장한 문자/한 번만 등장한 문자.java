import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String key : s.split("")) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) == 1) {
                answer += entry.getKey();
            }
        }

        String[] split = answer.split("");
        Arrays.sort(split);
        answer = "";

        for (String s1 : split) {
            answer += s1;
        }

        return answer;
    }
}