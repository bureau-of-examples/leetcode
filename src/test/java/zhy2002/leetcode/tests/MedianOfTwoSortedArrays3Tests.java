package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays3Tests {

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    @Test
    public void test3() {
        Node head = new Node(2);
        head.next = new Node(0);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        linksort(head);
    }

    void linksort(Node head)
    {
        Node[] sentinels = new Node[3];
        Node[] tails = new Node[sentinels.length];
        for (int i=0; i< sentinels.length; i++) {
            tails[i] = sentinels[i] = new Node(-1);
        }

        while (head != null) {
            tails[head.value].next = head;
            tails[head.value] = head;
            Node next = head.next;
            head.next = null;
            head = next;
        }
        tails[1].next = sentinels[2].next;
        tails[0].next = sentinels[1].next;
        Node pointer = sentinels[0].next;
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
    }

    @Test
    public void test2() {
        Solution2 solution2 = new Solution2();
        assertThat(
                solution2.findMedianSortedArrays(
                        new int[]{1, 2},
                        new int[]{3, 4, 5}
                ),
                equalTo(3.0)
        );
        assertThat(
                solution2.findMedianSortedArrays(
                        new int[]{1, 2},
                        new int[]{3, 4}
                ),
                equalTo(2.5)
        );
    }

    @Test
    public void test() {

        Solution solution = new Solution();
        assertThat(
                solution.findMedianSortedArrays(
                        new int[]{1, 1, 3, 3},
                        new int[]{1, 1, 3, 3}
                ),
                equalTo(2.0)
        );
        assertThat(
                solution.findMedianSortedArrays(
                        new int[]{2, 4, 5, 6},
                        new int[]{1, 3}
                ),
                equalTo(3.5)
        );
    }

    public class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            int lMid = (len - 1) / 2;
            double lMidValue = findValueForIndex(lMid, nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
            if (len % 2 == 1)
                return lMidValue;
            int uMid = len / 2;
            double uMidValue = findValueForIndex(uMid, nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
            return (lMidValue + uMidValue) / 2;
        }

        private int findValueForIndex(int index, int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
            if (start1 > end1)
                return nums2[start2 + index];
            if (start2 > end2)
                return nums1[start1 + index];
            if (index == 0)
                return Math.min(nums1[start1], nums2[start2]);
            int mid1 = (start1 + end1) >>> 1;
            int mid2 = (start2 + end2) >>> 1;
            int leftCount = mid1 - start1 + 1 + mid2 - start2;
            if (nums1[mid1] < nums2[mid2]) {
                if (index < leftCount) {
                    return findValueForIndex(index, nums1, nums2, start1, end1, start2, mid2 - 1);//rid of right of 2
                } else {
                    return findValueForIndex(index - (mid1 - start1 + 1), nums1, nums2, mid1 + 1, end1, start2, end2); //rid of left of 1
                }
            } else {
                if (index < leftCount) {
                    return findValueForIndex(index, nums1, nums2, start1, mid1 - 1, start2, end2); //rid of right of 1
                } else {
                    return findValueForIndex(index - (mid2 - start2 + 1), nums1, nums2, start1, end1, mid2 + 1, end2); //rid of left of 2
                }
            }
        }
    }

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            int lowMid = (len - 1) / 2;
            double lowMidValue = findValueOfIndexInMerged(lowMid, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
            if (len % 2 == 1) //odd
                return lowMidValue;
            int highMid = len / 2;
            double highMidValue = findValueOfIndexInMerged(highMid, nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
            return (lowMidValue + highMidValue) / 2;
        }

        private int findValueOfIndexInMerged(int index, int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
            if (start1 > end1)
                return nums2[start2 + index];
            if (start2 > end2)
                return nums1[start1 + index];
            if (index == 0)
                return Math.min(nums1[start1], nums2[start2]);
            int start1Pos = findFirstGreaterIndex(nums2, start2, end2, nums1[start1]);
            int len2 = start1Pos - start2;
            if (index == len2)
                return nums1[start1];
            if (index < len2)
                return findValueOfIndexInMerged(index, nums1, end1 + 1, end1, nums2, start2, start1Pos - 1);
            return findValueOfIndexInMerged(index - len2 - 1, nums1, start1 + 1, end1, nums2, start1Pos, end2);
        }

        private int findFirstGreaterIndex(int[] array, int start, int end, int target) {
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
