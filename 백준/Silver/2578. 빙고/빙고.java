import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int[] rowCount = new int[5];
	public static int[] colCount = new int[5];

	public static int count1 = 0; // '\' 대각선 카운팅
	public static int count2 = 0; // '/' 대각선 카운팅
	public static int bingoCnt = 0;
	public static int callCnt = 0;
	public static Map<Integer, int[]> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				callCnt++;
				int[] ints = map.get(Integer.parseInt(st.nextToken()));

				int x = ints[0];
				int y = ints[1];

				if(++rowCount[x] == 5) {
					bingoCnt++;
				}

				if(++colCount[y] == 5) {
					bingoCnt++;
				}

				if(x == y && ++count1 == 5) {
					bingoCnt++;
				}

				if (x + y == 4 && ++count2 == 5) {
					bingoCnt++;
				}

				if (bingoCnt >= 3) {
					System.out.println(callCnt);
					return;
				}
			}
		}
	}
}