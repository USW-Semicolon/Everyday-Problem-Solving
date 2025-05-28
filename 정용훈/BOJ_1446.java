import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1446 {
    private static Map<Integer, List<Road>> map = new HashMap<>();
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        dp = new int[D + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end > D) {
                continue;
            }

            if (end - start < cost) {
                continue;
            }

            map.putIfAbsent(end, new ArrayList<>());
            map.get(end).add(new Road(start, cost));
        }

        dijkstra();
        System.out.println(dp[D]);
    }

    private static void dijkstra() {
       for (int i = 0; i < dp.length; i++) {
           if (i != 0) {
               dp[i] = dp[i - 1] + 1;
           }

           if (map.containsKey(i)) {
               for (Road road : map.get(i)) {
                   dp[i] = Math.min(dp[i], dp[road.start] + road.cost);
               }
           }
       }
    }

    static class Road {
        int start;
        int cost;

        public Road(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
}
