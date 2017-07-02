package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.permutations.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermutationsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.permute(new int[]{});
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{4});
        assertEquals("[[4]]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{1, 3});
        assertEquals("[[1,3],[3,1]]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{1, 2, 3});
        assertEquals("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", Utils.listOfListToString(result));

    }

    @Test
    public void test2() {
        Solution2 solution2 = new Solution2();
        List<List<Integer>> result = solution2.permute(new int[]{1, 2, 3});
        assertEquals("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", Utils.listOfListToString(result));
    }

    public class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            populate(result, new ArrayList<>(), nums);
            return result;
        }

        private void populate(List<List<Integer>> result, ArrayList<Integer> template, int[] nums) {
            if (template.size() == nums.length) {
                result.add(new ArrayList<>(template));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (template.contains(num))
                    continue;
                template.add(num);
                populate(result, template, nums);
                template.remove(template.size() - 1);
            }
        }

    }
}
