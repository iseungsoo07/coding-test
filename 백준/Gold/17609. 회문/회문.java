import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < t; i++) {
            String str = br.readLine();

            result = checkPalindrome(str);

            if (result >= 2) {
                sb.append(result - 1).append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        int count = 0;

        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                count = 1;

                int l = left + 1;
                int r = right;

                while (l <= r) {
                    if (str.charAt(l) == str.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        count++;
                        break;
                    }
                }

                l = left;
                r = right - 1;

                while (l <= r) {
                    if (str.charAt(l) == str.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        count++;
                        break;
                    }
                }

                return count;
            }
        }

        return count;
    }
}
