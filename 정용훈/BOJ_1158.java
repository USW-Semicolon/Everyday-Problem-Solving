import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1158 {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for (int n = 1; n <= N; n++) {
            queue.add(n);
        }

        int K = Integer.parseInt(st.nextToken());
        List<Integer> answers = new ArrayList<>();

        while (queue.size() > 1) {
            answers.add(josephus(K));
        }
        answers.add(queue.poll());

        String result = answers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));

        System.out.println(result);
    }

    private static int josephus(int K) {
        for (int k = 0; k < K - 1; k++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }
}
