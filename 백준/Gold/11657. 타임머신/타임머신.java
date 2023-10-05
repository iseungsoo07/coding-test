import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    final static int INF = 1_000_000_000;
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] dist;
    static boolean isMinusCycle;

    static int n, m;

    public static void bellmanFord() {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);

                if (dist[edge.from] == INF) {
                    continue;
                }

                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;

                    if (i == n) {
                        isMinusCycle = true;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        bellmanFord();

        if (isMinusCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < n + 1; i++) {
                if (dist[i] >= INF) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dist[i]);
            }
        }
    }
}
