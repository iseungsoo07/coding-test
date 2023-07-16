import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];

            if (map.get(type) == null) {
                map.put(type, new ArrayList<>(Arrays.asList(name)));
            } else {
                ArrayList<String> name_list = map.get(type);
                name_list.add(name);
            }
        }

        System.out.println(map);

        for (Map.Entry<String, ArrayList<String>> entries : map.entrySet()) {
            String key = entries.getKey();
            ArrayList<String> strings = map.get(key);
            answer *= strings.size() + 1;
        }

        return answer - 1;
    }
}