import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] cities = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cities);

        int totalBudgets = Integer.parseInt(br.readLine());

        int result = calculateBudgets(cities, totalBudgets);

        System.out.println(result);
    }

    private static int calculateBudgets(int[] cities, int totalBudgets) {
        int minBudgets = totalBudgets / cities.length; // 값을 최소 도시 예산이 아닌 1/N 값으로 변경 ... (2) 오답노트
        int maxBudgets = cities[cities.length - 1];

        int result = 0;

        while (minBudgets <= maxBudgets) { // 최소나 최대값에서도 확인할 수 있도록 == 조건 추가 ...(3) 오답노트
            int midBudgets = (minBudgets + maxBudgets) / 2;

            if (canAssignBudgets(cities, midBudgets, totalBudgets)) {
                result = midBudgets; // 가능한 상한액을 저장해놓기 위한 라인   ... (1) 오답노트
                minBudgets = midBudgets + 1; // 더 큰 상한액이 가능한지 확인하기
            } else {
                maxBudgets = midBudgets - 1;
            }
        }

        return result;
    }

    private static boolean canAssignBudgets(int[] cities, int assignmentBudgets, int totalBudgets) {
        int sum = Arrays.stream(cities)
                .map(city -> Math.min(city, assignmentBudgets))
                .sum();

        return sum <= totalBudgets;
    }
}
