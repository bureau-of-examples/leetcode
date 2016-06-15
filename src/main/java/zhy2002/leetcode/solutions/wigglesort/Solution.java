package zhy2002.leetcode.solutions.wigglesort;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class Solution {

    public void wiggleSort(int[] nums) {
        boolean asc = false;
        for (int i = 1; i < nums.length; i++) {
            asc = !asc;
            int j = i;
            boolean asc2 = asc;
            while (j > 0 && (asc2 ? nums[j - 1] > nums[j] : nums[j - 1] < nums[j])) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                asc2 = !asc2;
                j--;
            }
        }
    }
}
