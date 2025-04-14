import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15650 {
    private static int N;
    private static int M;

    private static int[] answers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        answers = new int[M];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            Arrays.stream(answers)
                    .forEach(it -> System.out.print(it + " "));

            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            answers[depth] = i;
            backtracking(depth + 1);
            for (int j = i + 1; j <= N; j++) { // 오름차순으로 출력해야하므로 현재보다 작은 숫자들은 순회하지 않도록 true 값 유지시키기
                visited[j] = false;
            }
        }
    }
}
