import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int area = 0;
    static int cnt = 0;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    public static void dfs(int[][] map, int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return;
        }

        if (map[x][y] == 0) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        cnt++;

        for (int[] dir : dirs) {
            int xNext = dir[0] + x;
            int yNext = dir[1] + y;

            dfs(map, xNext, yNext);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    area++;
                    dfs(map, i, j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }

        System.out.println(area);
        Collections.sort(list);

        for (Integer cnt : list) {
            System.out.println(cnt);
        }
    }
}
