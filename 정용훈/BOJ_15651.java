import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15651 {
    private static int N;
    private static int M;

    private static int[] answers;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answers = new int[M];

        backtracking(0);

        System.out.println(sb);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < answers.length; i++) {
                sb.append(answers[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int n = 1; n <= N; n++) {
            answers[depth] = n;
            backtracking(depth + 1);
        }
    }
}
