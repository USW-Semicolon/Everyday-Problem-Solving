import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new String[N][M];
        for (int n = 0; n < N; n++) {
            board[n] = br.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int countMin = scanBoard(i, j);

                if (countMin < answer) {
                    answer = countMin;
                }
            }
        }

        System.out.println(answer);
    }

    private static int scanBoard(int i, int j) {
        int count = 0;

        for (int r = i; r < i + 8; r++) {
            for (int c = j; c < j + 8 ; c++) {
                if ((r + c) % 2 == 0) {
                    if (board[r][c].equals("W")) {
                        count++;
                    }
                } else {
                    if (board[r][c].equals("B")) {
                        count++;
                    }
                }
            }
        }

        return Math.min(count, 64 - count);
    }
}
