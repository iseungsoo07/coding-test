import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();

        while (!(str = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                    continue;
                }

                if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        sb.append("no\n");
                        flag = true;
                        break;
                    } else {
                        char pop = stack.pop();

                        if ((ch == ')' && pop == '[') || (ch == ']' && pop == '(')) {
                            sb.append("no\n");
                            flag = true;
                            stack.clear();
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                sb.append("no\n");
                flag = true;
            }

            if (!flag) {
                sb.append("yes\n");
            }
        }

        System.out.print(sb);
    }
}
