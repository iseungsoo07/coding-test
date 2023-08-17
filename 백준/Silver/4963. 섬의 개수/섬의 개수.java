import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (map[x][y] == 0) {
            return;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            dfs(map, visited, xNext, yNext);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int count = 0;
            st = new StringTokenizer(br.readLine());

            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            if (col == 0 && row == 0) {
                break;
            }

            int[][] map = new int[row][col];
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(map, visited, i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
