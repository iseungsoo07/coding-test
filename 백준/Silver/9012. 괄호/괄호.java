import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        String[] parenthesis = new String[T];
        boolean isVPS = true;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            parenthesis[i] = st.nextToken();
        }

        for (int i = 0; i < T; i++) {
            String str = parenthesis[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            isVPS = true;
            stack.clear();
        }
    }
}