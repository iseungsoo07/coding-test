import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (matrix[x][y] == 0) {
            return;
        }


        visited[x][y] = true;

        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            dfs(matrix, visited, xNext, yNext);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[row][col];
            boolean[][] visited = new boolean[row][col];
            int res = 0;

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                matrix[y][x] = 1;
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (matrix[j][k] == 1 && !visited[j][k]) {
                        res++;
                        dfs(matrix, visited, j, k);
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
