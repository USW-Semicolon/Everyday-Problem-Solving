import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = bfs(B, A);
        System.out.println(result);
    }

    private static int bfs(int start, int target) {
        Queue<Operation> queue = new LinkedList<>();
        queue.add(new Operation(start, 1));

        while (!queue.isEmpty()) {
            Operation poll = queue.poll();

            if (poll.value == 0) {
                break;
            }

            if (poll.value == target) {
                return poll.count;
            }

            if (poll.value % 2 == 0) {
                queue.add(new Operation(poll.value / 2, poll.count + 1));
            }

            if (poll.value % 10 == 1) {
                queue.add(new Operation(poll.value / 10, poll.count + 1));
            }
        }

        return -1;
    }

    static class Operation {
        int value;
        int count;

        public Operation(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
