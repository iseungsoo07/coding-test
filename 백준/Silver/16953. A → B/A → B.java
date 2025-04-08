import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int bfs(long num, long target, int count) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(num);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long cur = queue.poll();

                if (cur == target) {
                    return count + 1;
                }

                if (cur * 2 <= target) {
                    queue.add(cur * 2);
                }

                if (cur * 10 + 1 <= target) {
                    queue.add(cur * 10 + 1);
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        System.out.println(bfs(num, target, 0));
    }
}
