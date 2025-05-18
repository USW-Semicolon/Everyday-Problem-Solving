import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean flag = false;

        if (M >= 45) {
            M = M - 45;
        } else {
            M = 60 - (45 - M);
            flag = true;
        }

        if (flag) {
            if (H == 0) {
                H = 23;
            } else {
                H = H - 1;
            }
        }

        System.out.println(H + " " + M);
    }
}
