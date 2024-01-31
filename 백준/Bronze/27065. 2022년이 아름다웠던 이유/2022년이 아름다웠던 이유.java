import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static boolean isOver(int num, List<Integer> list) {

		int count = 0;

		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				list.add(i);
				count += i;
			}
		}

		if (count > num) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();

			boolean flag = false;

			List<Integer> list = new ArrayList<>();

			if (isOver(n, list)) {
				for (int j = 0; j < list.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					if (isOver(list.get(j), tmp)) {
						sb.append("BOJ 2022").append("\n");
						flag = true;
						break;
					}
				}

				if (!flag) {
					sb.append("Good Bye").append("\n");
				}
			} else {
				sb.append("BOJ 2022").append("\n");
			}
		}

		System.out.println(sb);
	}
}