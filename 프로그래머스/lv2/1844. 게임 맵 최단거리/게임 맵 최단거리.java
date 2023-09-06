import java.util.*;

class Solution {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static int bfs(int[][] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int xNext = curX + dir[0];
                int yNext = curY + dir[1];

                if (xNext < 0 || xNext >= maps.length || yNext < 0 || yNext >= maps[0].length) {
                    continue;
                }

                if (visited[xNext][yNext] || maps[xNext][yNext] == 0) {
                    continue;
                }

                visited[xNext][yNext] = true;
                queue.offer(new int[]{xNext, yNext});
                maps[xNext][yNext] = maps[curX][curY] + 1;
            }
        }

        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        } else {
            return maps[maps.length - 1][maps[0].length - 1];
        }

    }

    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;

        visited = new boolean[row][col];

        return bfs(maps, 0, 0);
    }
}