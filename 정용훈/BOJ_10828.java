import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 각각 System.out.println 로 호출
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        BOJStack stack = new BOJStack();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();

            switch (operator) {
                case "push" -> stack.push(Integer.parseInt(st.nextToken()));
                case "pop" -> System.out.println(stack.pop());
                case "size" -> System.out.println(stack.size());
                case "empty" -> System.out.println(stack.empty());
                case "top" -> System.out.println(stack.top());
                default -> throw new IllegalArgumentException();
            }
        }
    }

    static class BOJStack {
        private final List<Integer> stack = new ArrayList<>();

        public void push(int value) {
            stack.add(value);
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }

            return stack.remove(stack.size() - 1); // JDK 21 -> List.removeLast() 로 대체 가능
        }

        public int size() {
            return stack.size();
        }

        public int empty() {
            return stack.isEmpty() ? 1 : 0;
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }

            return stack.get(stack.size() - 1); // JDK 21 -> List.getLast() 로 대체 가능
        }
    }
}
