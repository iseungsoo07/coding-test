import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Data {

		String str;
		int num;
		int d;

		public Data(String str, int num, int d) {
			this.str = str;
			this.num = num;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Data[] datas = new Data[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			datas[i] = new Data(st.nextToken(), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(datas, (x, y) -> x.num - y.num);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < datas.length; i++) {
			sb.append(String.valueOf(datas[i].str.charAt(datas[i].d - 1)).toUpperCase());
		}

		System.out.println(sb);
	}

}
