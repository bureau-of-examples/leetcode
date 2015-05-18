package zhy2002.leetcode.solutions.minimumsizesubarraysum;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
       if(nums.length == 0)
           return 0;
       if(nums[0] >= s)
           return 1;

       int start = 0, end = 0;
        int minLen = 0;
        int sum = nums[0];
        while (++end < nums.length){
            sum += nums[end];
            boolean enterLoop = false;
            while (sum >= s){
                enterLoop = true;
                sum -= nums[start];
                start++;
            }

            if(enterLoop){
                if(minLen == 0)
                    minLen =  2 + end - start;
                else
                    minLen = Math.min(minLen, 2 + end - start);
            }
        }

        return minLen;
    }

}
