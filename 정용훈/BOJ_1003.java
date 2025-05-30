import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    private static Fibo[] dp = new Fibo[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        dp[0] = new Fibo(1, 0);
        dp[1] = new Fibo(0, 1);

        for (int i = 2; i < 41; i++) {
            dp[i] = new Fibo(dp[i - 1].callingZeroCount + dp[i - 2].callingZeroCount,
                    dp[i - 1].callingOneCount + dp[i - 2].callingOneCount);
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            dp[N].write(bw);
        }

        bw.flush();
        bw.close();
    }

    static class Fibo {
        private int callingZeroCount;
        private int callingOneCount;

        public Fibo(int zero, int one) {
            this.callingZeroCount = zero;
            this.callingOneCount = one;
        }

        public void write(BufferedWriter bw) throws IOException {
            bw.write(callingZeroCount + " " + callingOneCount + "\n");
        }
    }
}
