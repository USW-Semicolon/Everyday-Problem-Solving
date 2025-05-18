import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");

            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == board.length - 1 && current[1] == board[0].length - 1) {
                System.out.println(current[2]);
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                    continue;
                }

                if (board[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY, current[2] + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
