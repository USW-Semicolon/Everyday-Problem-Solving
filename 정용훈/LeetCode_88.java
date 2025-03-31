import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode_88 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6,}, 3);

        solution.merge(new int[]{1}, 1, new int[]{}, 0);

        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int answerArrayPointer = 0;

        int[] tempNums1 = Arrays.copyOf(nums1, m);
        int tempNumsPointer = 0;
        int nums2Pointer = 0;

        while (tempNumsPointer < m && nums2Pointer < n) {
            if (tempNums1[tempNumsPointer] < nums2[nums2Pointer]) {
                nums1[answerArrayPointer++] = tempNums1[tempNumsPointer++];
                continue;
            }

            if (tempNums1[tempNumsPointer] >= nums2[nums2Pointer]) {
                nums1[answerArrayPointer++] = nums2[nums2Pointer++];
            }
        }

        if (tempNumsPointer == m) {
            while (nums2Pointer < n) {
                nums1[answerArrayPointer++] = nums2[nums2Pointer++];
            }
        }

        if (nums2Pointer == n) {
            while (tempNumsPointer < m) {
                nums1[answerArrayPointer++] = tempNums1[tempNumsPointer++];
            }
        }
    }
}
