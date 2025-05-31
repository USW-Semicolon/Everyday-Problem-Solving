import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();

        int left = 0;
        int right = word.length - 1;

        boolean flag = true;

        while(left <= right) {
            if (word[left] != word[right]) {
                flag = false;
                break;
            }

            left++;
            right--;
        }

        System.out.println(flag ? 1 : 0);
    }
}
