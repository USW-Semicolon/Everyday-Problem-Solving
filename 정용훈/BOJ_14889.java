import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int N;
    private static int diff = Integer.MAX_VALUE;

    private static int[][] abilityBoard;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        abilityBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                abilityBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chooseMember(0, 0);

        System.out.println(diff);
    }

    private static void chooseMember(int index, int depth) {
        if (depth == N / 2) {
            int teamDiff = calculateDiff();

            if (teamDiff == 0) {
                System.out.println(0);
                System.exit(0);
            }

            if (diff > teamDiff) {
                diff = teamDiff;
            }

            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            chooseMember(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static int calculateDiff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += abilityBoard[i][j];
                    teamStart += abilityBoard[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    teamLink += abilityBoard[i][j];
                    teamLink += abilityBoard[j][i];
                }
            }
        }

        return Math.abs(teamStart - teamLink);
    }
}
