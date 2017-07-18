package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/3sum/#/description
 */
public class ThreeSum2Tests {

    @Test
    public void test() {

        Solution solution = new Solution();
        assertThat(
                Utils.listOfListToString(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})),
                equalTo("[[-1,-1,2],[-1,0,1]]")
        );
    }

    @Test
    public void test2() {
        Solution2 solution2 = new Solution2();
        assertThat(
                solution2.lengthOfLongestSubstring("tmmzuxt"),
                equalTo(5)
        );
    }

    public class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> lastCharIndex = new HashMap<>();
            int max = 0;
            int start = 0;
            for (int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if (lastCharIndex.containsKey(ch)) {
                    int newStart = lastCharIndex.get(ch) + 1;
                    for (int j = start; j<newStart; j++) {
                        lastCharIndex.remove(s.charAt(j));
                    }
                    start = newStart;
                    lastCharIndex.put(ch, i);
                } else {
                    lastCharIndex.put(ch, i);
                    max = Math.max(max, i - start + 1);
                }
            }
            return max;
        }
    }

    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i + 2 < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int sum2 = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int s = nums[start] + nums[end];
                    if (s == sum2) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]);
                        do {
                            end--;
                        } while (end >= 0 && nums[end] == nums[end + 1]);
                    } else if (s > sum2) {
                        do {
                            end--;
                        } while (end >= 0 && nums[end] == nums[end + 1]);
                    } else {
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]);
                    }
                }
            }
            return result;
        }
    }
}
