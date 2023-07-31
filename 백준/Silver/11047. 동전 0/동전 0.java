import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int result = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < coins.length; i++) {
            while (K != 0) {
                if (coins[i] <= K) {
                    result += K / coins[i];
                    K %= coins[i];
                }
                i++;
            }
        }

        System.out.println(result);
    }
}
