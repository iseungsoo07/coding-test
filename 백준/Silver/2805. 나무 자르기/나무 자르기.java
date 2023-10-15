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
        long m = Integer.parseInt(st.nextToken());

        int[] woods = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < woods.length; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = Arrays.stream(woods).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;

            for (int i = 0; i < woods.length; i++) {
                if (woods[i] > mid) {
                    sum += woods[i] - mid;
                }
            }

            if (sum >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

}