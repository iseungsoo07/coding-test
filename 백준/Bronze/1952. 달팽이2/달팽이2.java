import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] matrix = new boolean[M][N];

        int nowX = 0;
        int nowY = 0;
        matrix[nowX][nowY] = true;
        int sum = 1; // 지나온 칸수 (첫 번째 칸에서 시작)
        int count = 0; // 꺾은 횟수
        int idx = 0;

        while (sum != M * N) {
            int nextX = nowX + dir[idx % dir.length][0];
            int nextY = nowY + dir[idx % dir.length][1];

            if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !matrix[nextX][nextY]) {
                sum++;
                matrix[nextX][nextY] = true;
                nowX = nextX;
                nowY = nextY;
            } else {
                idx++;
                count++;
            }
        }

        System.out.println(count);
    }
}
