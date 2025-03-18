import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7795 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            count = 0;

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            List<Integer> AList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int a = 0; a < A; a++) {
                AList.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(AList);

            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < B; b++) {
                int prey = Integer.parseInt(st.nextToken());

                int min = 0;
                int max = A - 1;

                int check = 0;
                while (min <= max) {
                    int mid = (min + max) / 2;

                    if (AList.get(mid) > prey) {
                        check = A - mid;
                        max = mid - 1;
                    } else {
                        min = mid + 1;
                    }
                }

                count += check;
            }
            System.out.println(count);
        }
    }
}
