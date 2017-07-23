package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/#/description
 */
public class MedianOfTwoSortedArrays2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findMedianSortedArrays(new int[]{3, 5, 6, 7, 8}, new int[]{1, 2, 4}), equalTo(4.5d));
        assertThat(solution.findMedianSortedArrays(new int[]{1, 2, 3, 5}, new int[]{2, 4, 6}), equalTo(3d));
        assertThat(solution.findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}), equalTo(3.5d));
        assertThat(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5}), equalTo(3d));
        assertThat(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{2, 3}), equalTo(2d));
        assertThat(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{1}), equalTo(1d));
        assertThat(solution.findMedianSortedArrays(new int[]{1}, new int[]{1}), equalTo(1d));
    }

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int upperMid = (m + n) >>> 1;
            double upperMedian = find(upperMid, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
            if ((m + n) % 2 == 1)
                return upperMedian;
            double lowerMedian = find(upperMid - 1, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
            return (lowerMedian + upperMedian) / 2;
        }

        private double find(int index, int[] nums1, int nums1Start, int nums1End, int[] nums2, int nums2Start, int nums2End) {
            if (nums1Start > nums1End) {
                return nums2[nums2Start + index];
            }
            if (nums2Start > nums2End) {
                return nums1[nums1Start + index];
            }
            if (index == 0) {
                return Math.min(nums1[nums1Start], nums2[nums2Start]);
            }
            int nums1StartPos = findPos(nums2, nums2Start, nums2End, nums1[nums1Start]);
            if (index < (nums1StartPos - nums2Start))
                return nums2[nums2Start + index];
            if (nums1StartPos == nums2Start) {
                return find(index - 1, nums1, nums1Start + 1, nums1End, nums2, nums2Start, nums2End);
            }
            return find(index - (nums1StartPos - nums2Start), nums1, nums1Start, nums1End, nums2, nums1StartPos, nums2End);
        }

        private int findPos(int[] array, int start, int end, int target) {
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (array[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }
}
