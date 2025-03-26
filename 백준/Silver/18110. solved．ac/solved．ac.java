import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(br.readLine());
            arr[i] = level;
        }

        Arrays.sort(arr);

        int sum = 0;
        int cut = Math.round(n * 0.15F);
        int num = n - cut * 2;

        for (int i = cut; i < arr.length - cut; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (num * 1.0)));
    }
}
