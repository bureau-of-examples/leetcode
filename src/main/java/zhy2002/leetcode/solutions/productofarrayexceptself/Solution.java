package zhy2002.leetcode.solutions.productofarrayexceptself;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public interface Solution {

    int[] productExceptSelf(int[] nums);
}
