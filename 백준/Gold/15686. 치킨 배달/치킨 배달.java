import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N;
    static int M;

    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        backTracking(0, 0);
        System.out.println(result);
    }

    public static void backTracking(int depth, int idx) {
        if (depth == M) {
            int total = 0;
            for (int[] pos1 : house) {
                int dist = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        int[] pos2 = chicken.get(i);
                        // 집과 치킨집과의 거리 중 더 짧은 값을 채택
                        dist = Math.min(dist, Math.abs(pos2[0] - pos1[0]) + Math.abs(pos2[1] - pos1[1]));
                    }
                }
                total += dist; // 총 치킨거리의 합
            }

            result = Math.min(result, total); // 이전에 선택한 치킨집으로 계산한 도시의 치킨거리와 비교
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
