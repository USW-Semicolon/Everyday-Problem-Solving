import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    private static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            조합(N, M);
            sb.append(dp[N][M]).append("\n");
        }

        System.out.println(sb);
    }

    private static int 조합(int N, int M) {
        if (dp[N][M] != 0) {
            return dp[N][M];
        }

        if (N == M || N == 0) {
            return dp[N][M] = 1;
        }

        return dp[N][M] = 조합(N - 1, M - 1) + 조합(N, M - 1);
    }
}
