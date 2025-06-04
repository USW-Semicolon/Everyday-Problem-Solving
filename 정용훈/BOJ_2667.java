import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static String[][] map;
    private static boolean[][] visited;

    private static List<Integer> complexs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            map[i] = row;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++ ) {
                if (map[i][j].equals("1") && !visited[i][j]) {
                    complexs.add(bfs(i, j));
                }
            }
        }

        System.out.println(complexs.size());
        complexs.sort(Integer::compareTo);
        complexs.forEach(System.out::println);
    }

    private static int bfs(int row, int column) {
        Queue<Integer[]> queue = new LinkedList<>();

        visited[row][column] = true;
        queue.add(new Integer[]{row, column});
        int homeCount = 1;

        while (!queue.isEmpty()) {
            Integer[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
                    continue;
                }

                if (map[nextX][nextY].equals("1") && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Integer[]{nextX, nextY});
                    homeCount++;
                }
            }
        }

        return homeCount;
    }
}
