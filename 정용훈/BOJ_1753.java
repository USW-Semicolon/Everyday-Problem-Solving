import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_1753 {
    private static final int INF = Integer.MAX_VALUE;

    private static List<List<Node>> graph;
    private static int[] distance;

    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[K] = 0;

        graph = new ArrayList<>(V + 1);
        for (int v = 0; v < V + 1; v++) {
            graph.add(new ArrayList<>());
        }

        for (int e = 1; e <= E; e++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();

            List<Node> vertexIndex = graph.get(nowNode.destination);
            for (Node nextNode : vertexIndex) {
                if (nowNode.weight + nextNode.weight < distance[nextNode.destination]) {
                    distance[nextNode.destination] = nowNode.weight + nextNode.weight;
                    pq.add(new Node(nextNode.destination, nowNode.weight + nextNode.weight));
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        private int destination;
        private int weight;

        Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
