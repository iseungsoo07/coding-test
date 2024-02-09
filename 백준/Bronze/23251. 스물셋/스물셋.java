import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());

			for(int j = 0; j < k; j++) {
				sum += 23;
			}

			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}

}
