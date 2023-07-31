import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row + 1][col + 1];

        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2) {
                for (int j = y1; j <= y2; j++) {
                    result += arr[x1][j];
                }
            } else if (y1 == y2) {
                for (int j = x1; j <= x2; j++) {
                    result += arr[j][y1];
                }
            } else {
                for (int j = x1; j <= x2; j++) {
                    for (int k = y1; k <= y2; k++) {
                        result += arr[j][k];
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
