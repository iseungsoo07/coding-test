import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] set = new int[m];
        int[] each = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            set[i] = Integer.parseInt(st.nextToken());
            each[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set);
        Arrays.sort(each);

        int result = 0;

        while (n >= 6) {
            if (each[0] * 6 > set[0]) {
                result += set[0];
            } else {
                result += each[0] * 6;
            }
            n -= 6;
        }

        result += Math.min(n * each[0], set[0]);

        System.out.println(result);
    }
}
