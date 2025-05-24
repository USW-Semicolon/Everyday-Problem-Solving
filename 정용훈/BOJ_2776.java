import com.sun.jdi.ArrayReference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Set<Integer> note1 = new HashSet<>();
            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int value = Integer.parseInt(st.nextToken());

                int result = note1.contains(value) ? 1 : 0;
                bw.write(result + "");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
