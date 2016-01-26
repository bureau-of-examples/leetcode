package zhy2002.leetcode.solutions.maximumsizesubarraysumequalsk;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *Example 1:
 *Given nums = [1, -1, 5, -2, 3], k = 3,
 *return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 *Example 2:
 *Given nums = [-2, -1, 2, 1], k = 1,
 *return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 *Follow Up:
 *Can you do it in O(n) time?
 */
public class Solution {

    //first for each element calculate sum[i] which is the sum of all elements before it.
    //then we have sum[j] - sum[i] = the sum of elements in [i, j).
    //then for each j we want to find the smallest i so as to maximize the size of sub-array.
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];//sum of [0, i)
        sum[0] = 0;

        for(int i=0; i< nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        HashMap<Integer, Integer> targets = new HashMap<>();
        for(int i=sum.length - 1; i>=0; i--){
            targets.put(sum[i], i);
        }

        int result = 0;
        for(int j=sum.length - 1; j>0; j--) {
            if(j <= result)
                break;
            int target = sum[j] - k; //search for this
            Integer index = targets.get(target);
            if(index != null) {
                int subArrayLen = j - index;
                if(subArrayLen > result) {
                    result = subArrayLen;
                }
            }
        }
        return result;
    }

}
