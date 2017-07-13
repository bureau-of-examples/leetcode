package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/wiggle-sort/#/description
 */
public class WiggleSort2Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public void wiggleSort(int[] nums) {
            boolean rise = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (rise) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                    rise = false;
                } else {
                    if (nums[i] < nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                    rise = true;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public class Solution2 {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length - 1; i += 2) {
                swap(nums, i, i + 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
