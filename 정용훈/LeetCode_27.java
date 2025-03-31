import java.util.Arrays;

public class LeetCode_27 {

    public static void main(String[] args) {
        Solution_27 solution = new Solution_27();
        int k = solution.removeElement(new int[]{2}, 3);
    }
}

class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int assignPointer = 0;

        for (int checkPointer = 0; checkPointer < nums.length; checkPointer++) {
            if (nums[checkPointer] == val) {
                continue;
            }

            nums[assignPointer++] = nums[checkPointer];
        }

        return assignPointer;
    }
}
