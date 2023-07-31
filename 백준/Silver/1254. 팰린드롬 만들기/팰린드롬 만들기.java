import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int result = 0;

        boolean isPalindrome = true;
        isPalindrome = isPalindrome(s, 0, s.length() - 1);

        if (!isPalindrome) {
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(i + 1);
                if (isPalindrome(str, 0, str.length() - 1)) {
                    result = i + 1 + s.length();
                    break;
                }
            }
        } else {
            result = s.length();
        }

        System.out.println(result);
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
