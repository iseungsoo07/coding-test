import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int bfs(int[][] board, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result += 1;

            for (int[] dir : dirs) {
                int nextRow = cur[0] + dir[0];
                int nextCol = cur[1] + dir[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= board.length || nextCol >= board[0].length) {
                    continue;
                }

                if (board[nextRow][nextCol] == -1 || visited[nextRow][nextCol]) {
                    continue;
                }

                queue.offer(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = row - 1 - y1; j > row - 1 - y2; j--) {
                for (int l = x1; l < x2; l++) {
                    board[j][l] = -1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    count++;
                    board[i][j] = 1;
                    result.add(bfs(board, visited, i, j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(count);
        for (Integer i : result) {
            System.out.print(i + " ");
        }

    }
}
