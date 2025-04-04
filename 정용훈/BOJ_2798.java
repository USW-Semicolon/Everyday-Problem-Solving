import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
    private static int N;
    private static int M;

    private static int[] cards;
    private static boolean[] visited;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            cards[n] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int sum, int depth, int index) {
        if (depth == 3) {
            if (answer < sum && sum <= M) {
                answer = sum;
            }
            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(sum + cards[i], depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
