import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long sum = 0L;
        long i = 0L;

        while (sum < S) {
            i++;
            sum += i;
        }

        if (sum > S) {
            i--;
        }

        System.out.println(i);
    }
}
