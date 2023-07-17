import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] names = new int[N];
        int[] count = new int[20];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int name = names[i];
            int idx = 0;
            while (name > 0) {
                count[idx++] += name % 2; // 맨 뒷자리부터 넣음
                name /= 2;
            }
        }

        for (int i = 19; i >= 0; i--) {
            sum += (long) count[i] * (N - count[i]);
            sum = sum << 1;
        }
           
        sum = sum >> 1;
        System.out.println(sum);
    }
}
