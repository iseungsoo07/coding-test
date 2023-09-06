import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bottle {
    int a;
    int b;
    int c;

    public Bottle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    static Set<Integer> answer;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];
        answer = new HashSet<>();

        bfs(A, B, C);

        int[] ansArray = answer.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ansArray);
        for (int item : ansArray) {
            System.out.print(item + " ");
        }
    }

    public static void bfs(int A, int B, int C) {
        Queue<Bottle> queue = new LinkedList<>();

        queue.offer(new Bottle(0, 0, C));

        while (!queue.isEmpty()) {
            Bottle cur = queue.poll();

            if (cur.a == 0) {
                answer.add(cur.c);
            }

            if (visited[cur.a][cur.b][cur.c]) {
                continue;
            }

            visited[cur.a][cur.b][cur.c] = true;

            // B -> A
            if (cur.a + cur.b <= A) {
                queue.add(new Bottle(cur.a + cur.b, 0, cur.c));
            } else {
                queue.add(new Bottle(A, cur.a + cur.b - A, cur.c));
            }

            // C -> A
            if (cur.a + cur.c <= A) {
                queue.add(new Bottle(cur.a + cur.c, cur.b, 0));
            } else {
                queue.add(new Bottle(A, cur.b, cur.a + cur.c - A));
            }

            // A -> B
            if (cur.a + cur.b <= B) {
                queue.add(new Bottle(0, cur.a + cur.b, cur.c));
            } else {
                queue.add(new Bottle(cur.a + cur.b - B, B, cur.c));
            }

            // C -> B
            if (cur.c + cur.b <= B) {
                queue.add(new Bottle(cur.a, cur.b + cur.c, 0));
            } else {
                queue.add(new Bottle(cur.a, B, cur.b + cur.c - B));
            }

            // A -> C
            if (cur.a + cur.c <= C) {
                queue.add(new Bottle(0, cur.b, cur.a + cur.c));
            } else {
                queue.add(new Bottle(cur.a + cur.c - C, cur.b, C));
            }

            // B -> C
            if (cur.b + cur.c <= C) {
                queue.add(new Bottle(cur.a, 0, cur.b + cur.c));
            } else {
                queue.add(new Bottle(cur.a, cur.b + cur.c - C, C));
            }

        }

    }
}
