import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder sb = new StringBuilder();
        String reverseA;
        for (int i = A.length() - 1; i >= 0; i--) {
            sb.append(A.charAt(i));
        }
        reverseA = sb.toString();

        sb = new StringBuilder();
        String reverseB;
        for (int i = B.length() - 1; i >= 0; i--) {
            sb.append(B.charAt(i));
        }
        reverseB = sb.toString();

        System.out.println(
                Integer.parseInt(reverseA) > Integer.parseInt(reverseB) ? reverseA : reverseB);
    }
}
