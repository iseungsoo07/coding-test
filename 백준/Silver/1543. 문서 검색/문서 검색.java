import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String target = sc.nextLine();

        int result = 0;

        str = str.replaceAll(target, "X");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'X') {
                result++;
            }
        }

        System.out.println(result);
    }
}