import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_26 {

    public static void main(String[] args) {
        Solution_26 solution = new Solution_26();
        int k = solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}

class Solution_26 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int assignPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            nums[assignPointer++] = nums[i];
        }

        return set.size();
    }
}
