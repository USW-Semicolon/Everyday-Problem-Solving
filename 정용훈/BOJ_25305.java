import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_25305 {
    static int N;
    static int k;

    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            scores[n] = Integer.parseInt(st.nextToken());
        }

        quickSort(scores);

        System.out.println(scores[scores.length - k]);
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = (left + right) / 2;
        int pivotValue = array[pivot];

        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer <= rightPointer) {
            while (array[leftPointer] < pivotValue) {
                leftPointer++;
            }

            while (array[rightPointer] > pivotValue) {
                rightPointer--;
            }

            if (leftPointer <= rightPointer) {
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

        quickSort(array, left, rightPointer);
        quickSort(array, leftPointer, right);
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
