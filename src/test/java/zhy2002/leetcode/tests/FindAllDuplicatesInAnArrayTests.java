package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
 */
public class FindAllDuplicatesInAnArrayTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            int index = 0;
            while (index < nums.length) {
                if (nums[index] == index + 1) {
                    index++;
                } else {
                    int targetIndex = nums[index] - 1;
                    if (nums[targetIndex] == nums[index]) {
                        index++;
                    } else {
                        int temp = nums[targetIndex];
                        nums[targetIndex] = nums[index];
                        nums[index] = temp;
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1)
                    result.add(nums[i]);
            }
            return result;
        }
    }

}
