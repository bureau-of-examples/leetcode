package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
 */
public class KdiffPairsInAnArrayTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2), equalTo(2));
        assertThat(solution.findPairs(new int[]{1, 1, 1}, 0), equalTo(1));
        assertThat(solution.findPairs(new int[]{1, 1, 2, 2, 3, 1, 2, 5, 3, 2, 1}, 1), equalTo(2));
    }

    public class Solution {
        public int findPairs(int[] nums, int k) {
            if (k < 0)
                return 0;
            Set<String> kPairs = new HashSet<>();
            int[] diffs = {-k, k};
            for (int diff : diffs) {
                Map<Integer, Integer> targetMap = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    if (targetMap.containsKey(num)) {
                        int otherIndex = targetMap.get(num);
                        int otherNum = nums[otherIndex];
                        int thisNum = num;
                        if (thisNum > otherNum) {
                            int temp = thisNum;
                            thisNum = otherNum;
                            otherNum = temp;
                        }
                        kPairs.add(thisNum + "-" + otherNum);
                    }
                    targetMap.put(num + diff, i);
                }
            }

            return kPairs.size();
        }
    }
}
