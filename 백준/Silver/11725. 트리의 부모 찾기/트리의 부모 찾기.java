import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void dfs(ArrayList<Integer>[] list, boolean[] visited, int[] parents, int idx) {
        visited[idx] = true;
        for (int i : list[idx]) {
            if (!visited[i]) {
                parents[i] = idx;
                dfs(list, visited, parents, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] parents = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(list, visited, parents, 1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
}
