import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n, m;
    static int[] dist;
    final static int INF = 1_000_000_000;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);

                if (!visited[adjNode.to] && dist[adjNode.to] > dist[cur.to] + adjNode.weight) {
                    dist[adjNode.to] = dist[cur.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        System.out.println(dijkstra());
    }
}
