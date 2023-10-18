import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (n - i));
        }

        System.out.println(max);
    }
}
