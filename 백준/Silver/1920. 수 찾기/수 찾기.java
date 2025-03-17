import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        int[] M = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = A.length - 1;
            boolean flag = false;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (M[i] == A[mid]) {
                    sb.append(1).append("\n");
                    flag = true;
                    break;
                } else if (M[i] < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!flag) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }
}
