import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> map = new HashMap<>();
        StringTokenizer st = null;
        int result = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(value);
        }

        // 가장 마감일이 많이 남은 과제의 일 수를 구함
        int maxDate = Integer.MIN_VALUE;
        for (int date : map.keySet()) {
            maxDate = Math.max(maxDate, date);
        }

        List<Integer> scores = new ArrayList<>();

        for (int i = maxDate; i > 0; i--) {
            if (map.get(i) == null) {
                map.put(i, new ArrayList<>());
            }
            
            scores.addAll(map.get(i));
            
            if(scores.size() == 0) {
                continue;
            }

            int maxVal = scores.stream().mapToInt(Integer::intValue).max().getAsInt();
            result += maxVal;
            scores.remove(scores.indexOf(maxVal));
        }

        System.out.println(result);

    }
}
