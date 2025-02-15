import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int bingoCnt = 0;
	public static int[][] board = new int[5][5];

	public static boolean checkRow(int[] location) {
		int x = location[0];
		int y = location[1];

		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			if (board[x][i] != 0) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public static boolean checkCol(int[] location) {
		int x = location[0];
		int y = location[1];

		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			if (board[i][y] != 0) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public static boolean checkLeftDiagonal() {
		boolean flag = true;

		if (board[0][0] != 0 || board[1][1] != 0 || board[2][2] != 0 || board[3][3] != 0
			|| board[4][4] != 0) {
			flag = false;
		}

		return flag;
	}

	public static boolean checkRightDiagonal() {
		boolean flag = true;

		if (board[0][4] != 0 || board[1][3] != 0 || board[2][2] != 0 || board[3][1] != 0
			|| board[4][0] != 0) {
			flag = false;
		}

		return flag;
	}

	public static int[] find(int[][] board, int num) {
		int[] location = new int[2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == num) {
					location[0] = i;
					location[1] = j;
				}
			}
		}

		return location;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> callList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				callList.add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int idx = 0; idx < callList.size(); idx++) {
			int[] location = find(board, callList.get(idx));
			board[location[0]][location[1]] = 0;

			if (checkRow(location)) {
				bingoCnt++;
			}

			if (checkCol(location)) {
				bingoCnt++;
			}

			if (location[0] == location[1]) {
				if (checkLeftDiagonal()) {
					bingoCnt++;
				}
			}

			if (location[0] + location[1] == 4) {
				if (checkRightDiagonal()) {
					bingoCnt++;
				}
			}

			if (bingoCnt >= 3) {
				System.out.println(idx + 1);
				break;
			}

		}
	}
}
