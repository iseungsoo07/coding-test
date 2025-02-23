import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Main {

	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		LocalDate today = LocalDate.of(Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());

		LocalDate endDate = LocalDate.of(Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		if (today.isEqual(endDate)) {
			System.out.println("D-0");
			return;
		}

		if (today.plusYears(1000).isEqual(endDate)) {
			System.out.println("gg");
			return;
		}

		while (true) {
			LocalDate localDate = today.plusDays(1);
			today = localDate;
			count++;

			if (endDate.isAfter(today.plusYears(1000))) {
				System.out.println("gg");
				return;
			}

			if (localDate.isEqual(endDate)) {
				System.out.println("D-" + count);
				return;
			}
		}

	}
}