import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {
    private static int[][] dp = new int[11][11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = biomialCoefficient(N, K);

        System.out.println(result);
    }

    private static int biomialCoefficient(int N, int K) {
        if (dp[N][K] != 0) {
            return dp[N][K];
        }

        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = biomialCoefficient(N - 1, K -1) + biomialCoefficient(N - 1, K);
    }
}
