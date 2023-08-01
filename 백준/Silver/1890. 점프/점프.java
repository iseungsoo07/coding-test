import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int size = Integer.parseInt(br.readLine());

        int[][] arr = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[size + 1][size + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int next = arr[i][j];
                if (next == 0) {
                    break;
                }

                if (j + next <= size) {
                    dp[i][j + next] += dp[i][j];
                }

                if (i + next <= size) {
                    dp[i + next][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[size][size]);


    }
}
