import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] board;
    static int[][] rgb;
    static int[][] rb;
    static int rbCount = 0;
    static int rgbCount = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void rbBfs(int x, int y, char color, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        rb[x][y] = count;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if (nX >= N || nY >= N || nX < 0 || nY < 0) {
                    continue;
                }

                if (rb[nX][nY] != 0) {
                    continue;
                }

                char nextColor = board[nX][nY];

                if (nextColor == color || (nextColor == 'R' && color == 'G') || (nextColor == 'G'
                    && color == 'R')) {
                    rb[nX][nY] = count;
                    queue.offer(new int[]{nX, nY});
                }
            }
        }
    }

    public static void rgbBfs(int x, int y, char color, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        rgb[x][y] = count;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX >= N || nY >= N || nX < 0 || nY < 0) {
                    continue;
                }

                if (rgb[nX][nY] != 0) {
                    continue;
                }

                char nextColor = board[nX][nY];

                if (nextColor == color) {
                    rgb[nX][nY] = count;
                    queue.offer(new int[]{nX, nY});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        rgb = new int[N][N];
        rb = new int[N][N];

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] charArr = input.toCharArray();

            for (int j = 0; j < N; j++) {
                board[i][j] = charArr[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rgb[i][j] == 0) {
                    rgbBfs(i, j, board[i][j], ++rgbCount);
                }

                if (rb[i][j] == 0) {
                    rbBfs(i, j, board[i][j], ++rbCount);
                }
            }
        }

        System.out.println(rgbCount + " " + rbCount);
    }
}
