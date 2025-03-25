import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        sb.append("<");
        while (queue.size() > 1) {
            int cur = queue.poll();
            if (++count == K) {
                sb.append(cur).append(", ");
                count = 0;
                continue;
            }
            queue.offer(cur);
        }
        sb.append(queue.poll());
        sb.append(">");

        System.out.println(sb);
    }
}
