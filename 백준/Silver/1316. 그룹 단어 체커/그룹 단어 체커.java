import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int[] alphabet = new int[26];
			boolean groupCheck = true;

			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			alphabet[str.charAt(0) - 'a']++;
			for (int j = 1; j < str.length(); j++) {
				if (alphabet[str.charAt(j) - 'a'] != 0 && str.charAt(j) != str.charAt(j - 1)) {
					groupCheck = false;
					break;
				}

				alphabet[str.charAt(j) - 'a']++;
			}

			if (groupCheck) {
				count++;
			}
		}

		System.out.println(count);
	}

}
