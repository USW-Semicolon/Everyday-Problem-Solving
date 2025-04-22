import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (st.hasMoreTokens()) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        long smallDivisor = pq.poll();

        if (N == 1) {
            System.out.println(smallDivisor * smallDivisor);
            return;
        }

        while (pq.size() > 1) {
            pq.poll();
        }

        long bigDivisor = pq.poll();
        System.out.println(smallDivisor * bigDivisor);
    }
}
