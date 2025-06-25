import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] pascalTri = new int[n + 1][n + 1];

        pascalTri[1][1] = 1;

        for (int i = 2; i < pascalTri.length; i++) {
            for (int j = 1; j < pascalTri[i].length; j++) {
                pascalTri[i][j] = pascalTri[i - 1][j - 1] + pascalTri[i - 1][j];
            }
        }

        System.out.println(pascalTri[n][k]);

    }
}
