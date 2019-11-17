package zhy2002.leetcode.tests;

import org.junit.Test;

public class RotateArray2Tests {

    @Test
    public void test() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(input, 6);
        for (int i : input) {
            System.out.println(i);
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        int startIndex = 0;
        int startVal = nums[startIndex];
        int index = startIndex;
        for (int i = 0; i < nums.length; i++) {
            int fromIndex = (index - k + nums.length) % nums.length;
            if (fromIndex == startIndex) {
                nums[index] = startVal;
                startIndex = (index + 1) % nums.length;
                startVal = nums[startIndex];
                index = startIndex;
            } else {
                nums[index] = nums[fromIndex];
                index = fromIndex;
            }
        }
    }
}
