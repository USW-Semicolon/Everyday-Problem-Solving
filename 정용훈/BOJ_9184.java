import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9184 {
    static int[][][] recursionValue;

    public static void main(String[] args) throws IOException {
        recursionValue = init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            if (a <= 0 || b <= 0 || c <= 0) {
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + 1);
                bw.newLine();
                continue;
            }

            if (a > 20 || b > 20 || c > 20) {
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + recursionValue[20][20][20]);
                bw.newLine();
                continue;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + recursionValue[a][b][c]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static int[][][] init() {
        int[][][] values = new int[21][21][21];

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        values[i][j][k] = 1;
                        continue;
                    }

                    if (i < j && j < k) {
                        values[i][j][k] =
                                values[i][j][k - 1] + values[i][j - 1][k - 1] - values[i][j - 1][k];
                        continue;
                    }

                    values[i][j][k] =
                            values[i - 1][j][k] + values[i - 1][j - 1][k] + values[i - 1][j][k - 1] - values[i - 1][j - 1][k - 1];
                }
            }
        }

        return values;
    }
}
