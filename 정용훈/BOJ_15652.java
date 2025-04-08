import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652 {
    private static final StringBuilder sb = new StringBuilder();

    private static int N;
    private static int M;

    private static int[] answers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        answers = new int[M];

        backtracking(0);

        System.out.println(sb);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            Arrays.stream(answers)
                    .forEach(it -> sb.append(it).append(" "));

            sb.append("\n");
            return;
        }

        for (int n = 1; n <= N; n++) {
            if (depth > 0 && answers[depth - 1] > n) {
                continue;
            }

            answers[depth] = n;
            backtracking(depth + 1);

        }
    }
}
