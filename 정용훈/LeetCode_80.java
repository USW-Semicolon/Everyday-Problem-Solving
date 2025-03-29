import java.util.Arrays;

public class LeetCode_80 {

    public static void main(String[] args) {
        Solution_80 solution = new Solution_80();
        int k = solution.removeDuplicates(new int[]{0,0,1,1,1,1,1,2,3,3});

        System.out.println(k);
    }
}

class Solution_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 2) {
            return 2;
        }

        int assignPointer = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[assignPointer - 2]) {
                nums[assignPointer++] = nums[i];
            }
        }

        return assignPointer;
    }
}
