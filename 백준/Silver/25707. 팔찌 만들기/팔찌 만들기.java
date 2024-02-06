import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int sum = 0;

		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(arr[i + 1] - arr[i]);
		}

		System.out.println(sum + Math.abs(arr[0] - arr[N - 1]));
	}

}
