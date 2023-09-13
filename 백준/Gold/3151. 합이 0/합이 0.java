import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long result = 0;
        // 두 원소를 골랐을 때, 그 합을 0으로 만들어줄 원소 찾기
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];
                // 더 오른쪽에 있는 값만 찾음(중복 없애기 위해)
                // -> 어차피 더 왼쪽 범위에서 찾을 일 있다면, 해당 원소가 i 또는 j일 때 찾아짐
                int lower = lowerBound(arr, j + 1, N, -sum);
                int upper = upperBound(arr, j + 1, N, -sum);
                result += (upper - lower);
            }
        }
        System.out.println(result);
    }

    // left ~ right 범위에서 target을 찾는다.
    static int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return right; // target이 처음 나타나는 위치 반환
    }

    static int upperBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return right;   // target보다 처음 커지는 위치 반환
    }
}

