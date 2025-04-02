import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr, size));
    }

    public static int solution(int[] arr, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
