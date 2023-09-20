import java.util.Scanner;

public class Main {
    public static int r;
    public static int c;
    public static int result = 0;

    public static void recursive(int row, int col, int size) {
        if (size == 1) {
            System.out.println(result);
            return;
        }

        int newSize = size / 2;

        if (r < row + newSize && c >= col + newSize) { // 1사분면
            result += size * size / 4;
            recursive(row, col + newSize, newSize);
        } else if (r < row + newSize && c < col + newSize) { // 2사분면
            recursive(row, col, newSize);
        } else if (r >= row + newSize && c < col + newSize) { // 3사분면
            result += size * size / 4 * 2;
            recursive(row + newSize, col, newSize);
        } else if (r >= row + newSize && c >= col + newSize) { // 4사분면
            result += size * size / 4 * 3;
            recursive(row + newSize, col + newSize, newSize);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int size = (int) Math.pow(2, N);

        r = sc.nextInt();
        c = sc.nextInt();

        recursive(0, 0, size);

    }
}
