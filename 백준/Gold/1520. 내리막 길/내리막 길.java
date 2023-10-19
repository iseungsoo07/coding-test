import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[][] dp;

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int dfs(int row, int col) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;

        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if (nRow < 0 || nCol < 0 || nRow >= board.length || nCol >= board[0].length) {
                continue;
            }

            if (board[row][col] > board[nRow][nCol]) {
                dp[row][col] += dfs(nRow, nCol);
            }

        }

        return dp[row][col];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
}
