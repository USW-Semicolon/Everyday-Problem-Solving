import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    private static final int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    private static int[][] map;
    private static boolean[][] visited;

    private static List<IslandPosition> islands;
    private static Queue<IslandPosition> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            islands = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        islands.add(new IslandPosition(i, j));
                    }
                }
            }

            int islandsCount = 0;
            while (!islands.isEmpty()) {
                IslandPosition island = islands.remove(0);

                if (visited[island.row][island.column]) {
                    continue;
                }

                queue = new LinkedList<>();
                queue.add(island);

                while (!queue.isEmpty()) {
                    IslandPosition pos = queue.poll();

                    for (int i = 0; i < 8; i++) {
                        int nextRow = pos.row + dx[i];
                        int nextColumn = pos.column + dy[i];

                        if (nextRow < 0 || nextRow >= h || nextColumn < 0 || nextColumn >= w) {
                            continue;
                        }

                        if (map[nextRow][nextColumn] == 0 || visited[nextRow][nextColumn]) {
                            continue;
                        }

                        queue.add(new IslandPosition(nextRow, nextColumn));
                        visited[nextRow][nextColumn] = true;
                    }
                }

                islandsCount++;
            }

            System.out.println(islandsCount);
        }
    }

    static class IslandPosition {
        int row;
        int column;

        IslandPosition(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
