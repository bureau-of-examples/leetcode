package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class KDiffPairsInAnArray2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findPairs(new int[]{1, 1, 1, 2, 1}, 1), equalTo(1));
        assertThat(solution.findPairs(new int[]{1, 3, 1, 5, 4}, 0), equalTo(1));
        assertThat(solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2), equalTo(2));
    }

    public class Solution {
        public int findPairs(int[] nums, int k) {
            if (k < 0)
                return 0;
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> lastIndex = new HashMap<>();
            Map<Integer, Integer> flags = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                lastIndex.put(nums[i], i);
            }
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int flag = 0;
                if (i == lastIndex.get(num)) {
                    if (set.contains(num + k)) {
                        if (flags.get(num + k) < 2) { //num + k did not match a previous -k
                            count++;
                            flag |= 1;
                        }
                    }
                    if (k != 0 && set.contains(num - k)) { //num - k did not match a previous +k
                        if (flags.get(num - k) % 2 == 0) {
                            count++;
                            flag |= 2;
                        }
                    }
                }
                flags.put(num, flag);
                set.add(num);
            }
            return count;
        }
    }
}
