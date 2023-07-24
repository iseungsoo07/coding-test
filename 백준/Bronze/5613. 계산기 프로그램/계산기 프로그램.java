import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int idx = 0;
        int num = 0;
        String op = "";

        while (true) {
            if (idx % 2 == 0) {
                num = sc.nextInt();
                if (idx == 0) {
                    result += num;
                    idx++;
                    continue;
                }
            } else {
                op = sc.next();
                if ("=".equals(op)) {
                    break;
                }
                idx++;
                continue;
            }

            if ("+".equals(op)) {
                result += num;
            } else if ("-".equals(op)) {
                result -= num;
            } else if ("*".equals(op)) {
                result *= num;
            } else if ("/".equals(op)) {
                result /= num;
            }
            idx++;
        }

        System.out.println(result);
    }
}
