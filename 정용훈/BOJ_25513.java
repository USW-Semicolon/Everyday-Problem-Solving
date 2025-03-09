import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25513 {
    private static final int[][] board = new int[5][5];

    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    private static int totalMovingCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Position nowPosition = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= 6; i++) {
            boolean found = false;
            Queue<Position> queue = new LinkedList<>();
            queue.add(nowPosition);

            boolean[][] visited = new boolean[5][5];

            while (!queue.isEmpty()) {
                Position current = queue.poll();
                visited[current.row][current.column] = true;

                if (current.isOnTarget(i)) {
                    totalMovingCount += current.getMovingCount();
                    nowPosition = new Position(current.row, current.column);
                    found = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nextRow = current.row + dx[d];
                    int nextColumn = current.column + dy[d];

                    if (nextRow < 0 || nextRow >= 5 || nextColumn < 0 || nextColumn >= 5) {
                        continue;
                    }

                    if (board[nextRow][nextColumn] == -1) {
                        continue;
                    }

                    if (visited[nextRow][nextColumn]) {
                        continue;
                    }

                    queue.add(current.moveTo(nextRow, nextColumn));
                }
            }

            if (!found) {
                totalMovingCount = -1;
                break;
            }
        }

        System.out.println(totalMovingCount);
    }

    static class Position {
        int row;
        int column;
        int movingCount;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
            movingCount = 0;
        }

        private Position(int row, int column, int movingCount) {
            this.row = row;
            this.column = column;
            this.movingCount = movingCount;
        }

        public Position moveTo(int row, int column) {
            return new Position(row, column, this.movingCount + 1);
        }

        public int getMovingCount() {
            return this.movingCount;
        }

        private boolean isOnTarget(int target) {
            return board[row][column] == target;
        }
    }
}
