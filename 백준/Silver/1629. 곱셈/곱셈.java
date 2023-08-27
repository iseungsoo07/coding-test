import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long recursive(int A, int B, int C) {
        if (B == 1) {
            return A % C;
        }

        // 지수의 절반에 해당하는 A^(B / 2) 을 구한다.
        long temp = recursive(A, B / 2, C);

        /*
         * 현재 지수가 홀 수 였다면
         * A^(B / 2) * A^(B / 2) * A 이므로
         * A를 한 번 더 곱해주어야 한다.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if (B % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        // 그 외에는 짝수이므로 구했던 값을 한 번 더 곱해서 반환한다.
        return temp * temp % C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(recursive(A, B, C));
    }
}