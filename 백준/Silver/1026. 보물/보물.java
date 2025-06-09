import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int[] A = new int[tc];
        int[] B = new int[tc];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < tc; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < tc; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;

        int count = 0;
        int right = A.length - 1;
        int left = 0;

        while (count < tc) {
            result += A[right] * B[left];
            right--;
            left++;
            count++;
        }

        System.out.println(result);
    }
}
