import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(s[1]));
            } else if (s[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop_front")) {
                Integer data = deque.pollFirst();
                if (data == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(data).append("\n");
                }
            } else if (s[0].equals("pop_back")) {
                Integer data = deque.pollLast();
                if (data == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(data).append("\n");
                }
            } else if (s[0].equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (s[0].equals("empty")) {
                sb.append((deque.isEmpty() ? 1 : 0)).append("\n");
            } else if (s[0].equals("front")) {
                Integer data = deque.peekFirst();
                if (data == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(data).append("\n");
                }
            } else if (s[0].equals("back")) {
                Integer data = deque.peekLast();
                if (data == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(data).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}