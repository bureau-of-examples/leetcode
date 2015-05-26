package zhy2002.leetcode.solutions.kthlargestelementinanarray;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {

    private java.util.Random random = new java.util.Random();

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];


        //partition
        int index = start + random.nextInt(end - start + 1);
        if (index != start) {
            int temp = nums[start];
            nums[start] = nums[index];
            nums[index] = temp;
        }

        int boundary = start;//end of first partition
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] >= nums[start]) {
                int newPos = boundary + 1;
                if (i != newPos) {
                    int temp = nums[newPos];
                    nums[newPos] = nums[i];
                    nums[i] = temp;
                }
                boundary++;
            }

        }

        int length = boundary - start + 1;//length of first partition
        if(length == k)
            return nums[start];

        if(length > k)
            return findKthLargest(nums, start + 1, boundary, k);
        else
            return findKthLargest(nums, boundary + 1, end, k - length);

    }


}
