package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 */
public class FindAllNumbersDisappearedInAnArrayTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int index = 0;
            while (index < nums.length) {
                if (nums[index] == index + 1) {
                    index++;
                } else {
                    int wrong = nums[index];
                    int temp = nums[wrong - 1];
                    if (temp == wrong) {
                        index++;
                    } else {
                        nums[wrong - 1] = wrong;
                        nums[index] = temp;
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                if (nums[i - 1] != i) {
                    result.add(i);
                }

            }
            return result;
        }
    }

}
