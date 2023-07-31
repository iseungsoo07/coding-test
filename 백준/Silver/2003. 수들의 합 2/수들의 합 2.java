import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        int count = 0;

        while (p1 < N && p2 < N) {
            int sum = 0;
            for (int i = p1; i <= p2; i++) {
                sum += num[i];
            }

            if (sum == M) {
                count++;
                p2++;
            } else if (sum < M) {
                p2++;
            } else {
                p1++;
            }
        }

        System.out.println(count);
    }

}
