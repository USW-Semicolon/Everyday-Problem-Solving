import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        sort(array);

        Arrays.stream(array)
                .forEach(System.out::println);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(array, low, high);

        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int left = low;
        int right = high;
        int pivotValue = array[(low + high) / 2];

        while (true) {
            while (array[left] < pivotValue) {
                left++;
            }

            while (array[right] > pivotValue && left <= right) {
                right--;
            }

            if (left >= right) {
                return right;
            }

            swap(array, left, right);
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
