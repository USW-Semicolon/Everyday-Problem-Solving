import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a % 10 == 0) {
                sb.append(10).append("\n");
                continue;
            }

            int num = 1;
            for (int i = 0; i < b; i++) {
                num = (a * num) % 10;
                if (num == 0) {
                    num = 10;
                }
            }

            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
