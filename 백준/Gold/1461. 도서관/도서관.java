import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int n = Integer.parseInt(st.nextToken()); // 총 책의 수
        int m = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책의 수

        st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(st.nextToken());

            if (max < Math.abs(pos)) {
                max = Math.abs(pos);
            }

            if (pos > 0) {
                plus.add(pos);
            } else {
                minus.add(Math.abs(pos));
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        for (int i = 0; i < plus.size(); i++) {
            if (i % m == 0 && plus.get(i) == max) {
                answer += plus.get(i);
            } else if (i % m == 0) {
                answer += plus.get(i) * 2;
            }
        }

        for (int i = 0; i < minus.size(); i++) {
            if (i % m == 0 && minus.get(i) == max) {
                answer += minus.get(i);
            } else if (i % m == 0) {
                answer += minus.get(i) * 2;
            }
        }

        System.out.println(answer);
    }
}
