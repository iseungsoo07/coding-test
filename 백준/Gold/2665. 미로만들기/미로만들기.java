import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] blackCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] rooms = new int[n][n];
        blackCnt = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                rooms[i][j] = Character.getNumericValue(str.charAt(j));
                blackCnt[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(rooms, 0, 0);
    }

    public static void bfs(int[][] rooms, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        blackCnt[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int xNext = curX + dir[0];
                int yNext = curY + dir[1];

                if (xNext < 0 || yNext < 0 || xNext >= rooms.length || yNext >= rooms[0].length) {
                    continue;
                }

                if (blackCnt[xNext][yNext] > blackCnt[curX][curY]) {
                    if (rooms[curX][curY] == 1) {
                        blackCnt[xNext][yNext] = blackCnt[curX][curY];
                    } else {
                        blackCnt[xNext][yNext] = blackCnt[curX][curY] + 1;
                    }
                    queue.offer(new int[]{xNext, yNext});
                }
            }
        }

        System.out.println(blackCnt[rooms.length - 1][rooms[0].length - 1]);
    }
}
