import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int[][] rupeeMap;
    private static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int problem = 0;
        while (true) {
            problem++;
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            rupeeMap = new int[N][N];
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 0; m < N; m++) {
                    rupeeMap[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            distance = new int[N][N];
            for (int d = 0; d < N; d++) {
                Arrays.fill(distance[d], Integer.MAX_VALUE);
            }
            distance[0][0] = rupeeMap[0][0];

            djikstra();
            bw.write("Problem " + problem + ": " + distance[N - 1][N - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void djikstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, distance[0][0]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= rupeeMap.length || nextY < 0 || nextY >= rupeeMap.length) {
                    continue;
                }

                if (distance[nextX][nextY] > current.k + rupeeMap[nextX][nextY]) {
                    distance[nextX][nextY] = current.k + rupeeMap[nextX][nextY];
                    queue.add(new Node(nextX, nextY, distance[nextX][nextY]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int k;

        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        @Override
        public int compareTo(Node o) {
            return this.k - o.k;
        }
    }
}
