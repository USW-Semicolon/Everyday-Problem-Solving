import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.System.exit;

public class BOJ_1417 {
    private static final Queue<Candidator> candidators = new PriorityQueue<>();

    private static Candidator dasom;
    private static int buy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dasom = new Candidator(1, Integer.parseInt(br.readLine()));

        if (N == 1) {
            System.out.println(0);
            exit(0);
        }

        for (int i = 2; i <= N; i++) {
            candidators.add(new Candidator(i, Integer.parseInt(br.readLine())));
        }

        while (candidators.peek().isMoreThanOrEqualDasom()) {
            Candidator candidator = candidators.poll();
            candidator.loseSupporter();
            candidators.add(candidator);
        }

        System.out.println(buy);
    }

    static class Candidator implements Comparable<Candidator> {
        int number;
        int supporterCount;

        public Candidator(int number, int supporterCount) {
            this.number = number;
            this.supporterCount = supporterCount;
        }

        @Override
        public int compareTo(Candidator o) {
            return o.supporterCount - this.supporterCount;
        }

        public boolean isMoreThanOrEqualDasom() {
            return this.supporterCount >= dasom.supporterCount;
        }

        public void loseSupporter() {
            this.supporterCount--;

            dasom.supporterCount++;
            buy++;
        }
    }
}
