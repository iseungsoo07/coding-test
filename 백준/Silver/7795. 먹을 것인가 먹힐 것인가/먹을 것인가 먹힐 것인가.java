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

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());

            int[] a = new int[Integer.parseInt(st.nextToken())];
            int[] b = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a.length; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b.length; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int aP = 0;
            int bP = 0;

            while (true) {
                if (bP >= b.length) {
                    aP++;
                    bP = 0;
                }

                if (aP >= a.length) {
                    break;
                }

                if (a[aP] > b[bP++]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);


    }
}
