package zhy2002.leetcode.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/next-greater-element-i/#/description
 */
public class NextGreaterElementITests {

    public class Solution {
        public int[] nextGreaterElement(int[] findNums, int[] nums) {
            Map<Integer, Integer> nums1Index = new HashMap<>();
            for (int i = 0; i < findNums.length; i++) {
                nums1Index.put(findNums[i], i);
            }

            int[] result = new int[findNums.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = -1;
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                if (nums1Index.containsKey(num)) {
                    queue.add(num);
                }
                while (!queue.isEmpty() && queue.peek() < num) {
                    int num1 = queue.poll();
                    result[nums1Index.get(num1)] = num;
                }
            }

            return result;
        }
    }
}
