import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n; i++) {
            String func = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();
            String[] arr =
                arrayInput.equals("[]") ? new String[0] : arrayInput.replace("[", "").replace("]", "").split(",");


            Deque<String> deque = new ArrayDeque<>(Arrays.asList(arr));

            boolean errorCheck = false;
            boolean front = true;

            for (int j = 0; j < func.length(); j++) {
                char ch = func.charAt(j);

                if (ch == 'R') {
                    front = !front;
                } else if (ch == 'D') {
                    if (deque.isEmpty()) {
                        errorCheck = true;
                        sb.append("error\n");
                        break;
                    }

                    if (front) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (!errorCheck) {
                sb.append("[");

                while (!deque.isEmpty()) {
                    if (front) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }

                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}
