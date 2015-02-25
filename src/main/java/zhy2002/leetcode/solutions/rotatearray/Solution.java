package zhy2002.leetcode.solutions.rotatearray;

/**
 * https://oj.leetcode.com/problems/rotate-array/
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        //calc effective k
        if(nums.length <= 1)
            return;

        int effectiveK = (k < 0 ? -k : k) % nums.length;
        if(effectiveK == 0)
            return;

        if(k < 0)
            effectiveK = nums.length - k;

        int targetIndex = 0;
        int groupIndex = targetIndex;
        int val0 = nums[groupIndex];
        for(int i=0; i< nums.length; i++){
            int sourceIndex = (targetIndex - effectiveK + nums.length)%nums.length;
            if(sourceIndex == groupIndex){
                nums[targetIndex] = val0;
                val0 = nums[++groupIndex];
                targetIndex = groupIndex;
            } else {
                nums[targetIndex] = nums[sourceIndex];
                targetIndex = sourceIndex;
            }
        }
    }

    public void rotate2(int[] nums, int k){
        //calc effective k
        if(nums.length <= 1)
            return;

        int effectiveK = (k < 0 ? -k : k) % nums.length;
        if(effectiveK == 0)
            return;

        if(k < 0)
            effectiveK = nums.length - k;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, effectiveK - 1);
        reverse(nums, effectiveK, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


