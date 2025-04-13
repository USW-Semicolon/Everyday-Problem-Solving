import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12789 {
    private static Queue<Integer> queue = new LinkedList<>();
    private static Deque<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int currentNum = 1;

        while (currentNum <= N) {
            if (!stack.isEmpty() && stack.peek() == currentNum) {
                stack.pop();
                currentNum++;
                continue;
            }

            if (!queue.isEmpty() && queue.peek() == currentNum) {
                queue.remove();
                currentNum++;
                continue;
            }

            if (queue.isEmpty() && stack.peek() != currentNum) {
                System.out.println("Sad");
                System.exit(0);
            }

            stack.push(queue.remove());
        }

        System.out.println("Nice");
    }
}
