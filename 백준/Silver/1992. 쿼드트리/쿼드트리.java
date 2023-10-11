import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void quadTree(int n, int row, int col) {
        if (check(row, col, n)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = n / 2;

        sb.append("(");
        quadTree(newSize, row, col);
        quadTree(newSize, row, col + newSize);
        quadTree(newSize, row + newSize, col);
        quadTree(newSize, row + newSize, col + newSize);
        sb.append(")");

    }

    public static boolean check(int a, int b, int n) {

        int value = board[a][b];

        for (int i = a; i < a + n; i++) {
            for (int j = b; j < b + n; j++) {
                if (board[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        quadTree(n, 0, 0);

        System.out.println(sb);
    }
}
