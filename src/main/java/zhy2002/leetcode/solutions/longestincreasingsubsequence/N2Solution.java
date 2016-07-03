package zhy2002.leetcode.solutions.longestincreasingsubsequence;




public class N2Solution implements Solution{

    @Override
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] = length of LIS end at index i.
        int maxLen = 0;
        for(int i=0; i<nums.length; i++) {
            int len = 0;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[j] > len) {
                    len = dp[j];
                }
            }
            dp[i] = len + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
