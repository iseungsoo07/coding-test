import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] adjMat;
    static int result = 0;
    static boolean[] visited;

    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i < adjMat.length; i++) {
                if (adjMat[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    result++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int computerCnt = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        adjMat = new int[computerCnt + 1][computerCnt + 1]; // 1번부터 시작
        visited = new boolean[computerCnt + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjMat[v1][v2] = adjMat[v2][v1] = 1;
        }

        bfs(1);
        System.out.println(result);

    }
}
