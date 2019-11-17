package zhy2002.leetcode.tests;

import org.junit.Test;

public class MoveZeroes2Tests {

    @Test
    public void test() {
        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int first0 = 0;
        int nextNon0 = 1;
        while (first0 < nums.length) {
            if (nums[first0] != 0) {
                first0++;
                continue;
            }

            nextNon0 = Math.max(nextNon0, first0 + 1);
            while (nextNon0 < nums.length) {
                if (nums[nextNon0] == 0) {
                    nextNon0++;
                } else {
                    break;
                }
            }
            if (nextNon0 == nums.length) {
                break;
            }
            swap(nums, first0++, nextNon0++);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
