import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = a;
                minDp[0] = a;

                maxDp[1] = b;
                minDp[1] = b;

                maxDp[2] = c;
                minDp[2] = c;
            } else {
                int prev0 = maxDp[0];
                int prev2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
                maxDp[1] = Math.max(prev0, Math.max(maxDp[1], prev2)) + b;

                prev0 = minDp[0];
                prev2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + a;
                minDp[2] = Math.min(minDp[1], minDp[2]) + c;
                minDp[1] = Math.min(prev0, Math.min(minDp[1], prev2)) + b;
            }

        }
        System.out.println(Arrays.stream(maxDp).max().getAsInt());
        System.out.println(Arrays.stream(minDp).min().getAsInt());
    }
}
