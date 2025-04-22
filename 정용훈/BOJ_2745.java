import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2745 {
    private static Map<Character, Integer> baseParser;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        baseParser = initBaseParser();

        char[] n = N.toCharArray();

        int answer = 0;
        for (int i = 0; i < n.length; i++) {
            answer += baseParser.get(n[i]) * (int)Math.pow(B, n.length - i - 1);
        }

        System.out.println(answer);
    }

    private static Map<Character, Integer> initBaseParser() {
        Map<Character, Integer> baseParser = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            baseParser.put((char)('0' + i), i);
        }

        for (int i = 0; i < 26; i++) {
            baseParser.put((char)('A' + i), i + 10);
        }

        return baseParser;
    }
}
