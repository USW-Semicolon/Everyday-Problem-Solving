import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][N + 1];

        long result = biomialCoefficient(N, K);
        System.out.println(result % 10007);
    }

    private static long biomialCoefficient(int N, int K) {
        if (dp[N][K] != 0L){
            return dp[N][K];
        }

        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = (biomialCoefficient(N - 1, K) + biomialCoefficient(N - 1, K - 1)) % 10007;
    }
}
