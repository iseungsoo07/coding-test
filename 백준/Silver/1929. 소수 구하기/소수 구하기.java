import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] arr = new int[to + 1];

        for (int i = 2; i <= to; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(to); i++) {
            if (arr[i] != 0) {
                for (int j = i + i; j <= to; j = j + i) {
                    arr[j] = 0;
                }
            }
        }

        for (int i = from; i <= to; i++) {
            if (arr[i] != 0) {
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.println(sb);

    }
}
