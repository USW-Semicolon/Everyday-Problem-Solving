import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();

            if (set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        list.forEach(System.out::println);
    }
}
