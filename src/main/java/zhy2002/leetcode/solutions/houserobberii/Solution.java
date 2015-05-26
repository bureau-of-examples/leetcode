package zhy2002.leetcode.solutions.houserobberii;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * The optimal solution is in one of the two categories:
 * rob from second to last
 * rob from first to second last
 * These two categories are solved by rob house i.
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
    }

    private int rob(int[] nums, int start, int end) {
        int rob = nums[start];
        int noRob = 0;

        for (int i = start + 1; i <= end; i++) {
            int newRob = noRob + nums[i];
            if(rob > noRob){
                noRob = rob;
            }
            rob = newRob;
        }

        return Math.max(rob, noRob);
    }
}
