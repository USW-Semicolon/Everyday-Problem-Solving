import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.StringTokenizer;

public class BOJ_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        IntQueue queue = new IntQueue();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();

            switch (operator) {
                case "push" -> queue.push(Integer.parseInt(st.nextToken()));
                case "pop" -> bw.write(queue.pop()  + "\n");
                case "size" -> bw.write(queue.size() + "\n");
                case "empty" -> bw.write(queue.empty() + "\n");
                case "front" -> bw.write(queue.front() + "\n");
                case "back" -> bw.write(queue.back() + "\n");
                default -> throw new IllegalArgumentException();
            }
        }

        bw.flush();
        bw.close();
    }

    private static class IntQueue {
        private final Deque<Integer> queue;

        IntQueue() {
            this.queue = new LinkedList<>();
        }

        public void push(int value) {
            queue.add(value);
        }

        public int pop() {
            return Optional.ofNullable(queue.poll())
                    .orElse(-1);
        }

        public int size() {
            return queue.size();
        }

        public int empty() {
            return queue.isEmpty() ? 1 : 0;
        }

        public int front() {
            return Optional.ofNullable(queue.peekFirst())
                    .orElse(-1);
        }

        public int back() {
            return Optional.ofNullable(queue.peekLast())
                    .orElse(-1);
        }
    }
}
