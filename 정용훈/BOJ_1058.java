import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1058 {
    private static String[] friendsBoard;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        friendsBoard = new String[N];

        for (int i = 0; i < N; i++) {
            friendsBoard[i] = br.readLine();
        }

        int answer = 0;

        for (int n = 0; n < N; n++) {
            int friendCounts = findFriends(n);

            if (answer < friendCounts) {
                answer = friendCounts;
            }
        }

        System.out.println(answer);
    }

    private static int findFriends(int n) {
        Set<Integer> twoFriends = new HashSet<>();

        for (int i = 0; i < N; i++) {
            char friend = friendsBoard[n].charAt(i);

            if ('Y' == friend) {
                twoFriends.add(i);

                addTwoStepFriends(twoFriends, n, i);
            }
        }

        return twoFriends.size();
    }

    private static void addTwoStepFriends(Set<Integer> twoFriends, int me, int oneFriend) {
        for (int i = 0; i < N; i++) {
            char friend = friendsBoard[oneFriend].charAt(i);

            if ('Y' == friend) {
                if (i == me) {
                    continue;
                }

                if (twoFriends.contains(i)) {
                    continue;
                }

                twoFriends.add(i);
            }
        }
    }



}
