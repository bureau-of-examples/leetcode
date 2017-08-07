package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/discuss/
 */
public class WiggleSortIITests {

    @Test
    public void test() {
        SortingSolution sortingSolution = new SortingSolution();
        int[] input = {1, 3, 2, 2, 3, 1}; //{1, 5, 1, 1, 6, 4};
        sortingSolution.wiggleSort(input);
        printArray(input);
        assertThat(true, equalTo(true));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] input = {3, 1, 1, 5, 4, 2, 3};
        int result = solution.kthIndex(input, 5, 0, input.length - 1);
        System.out.println(result);
        printArray(input);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] input = {1, 3, 2, 2, 3, 1}; //{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(input);
        printArray(input);
    }

    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    public void test4() {
        WebSolution webSolution = new WebSolution();
        int[] input = {6, 13, 5, 4, 5, 2};
        webSolution.wiggleSort(input);
        printArray(input);
    }

    public class WebSolution {

        private Random random = new Random();

        public void wiggleSort(int[] nums) {
            int median = kthIndex(nums, nums.length / 2, 0, nums.length - 1);
            int n = nums.length;

            int left = 0, i = 0, right = n - 1;
            while (i <= right) {
                if (nums[newIndex(i, n)] > median) {
                    swap(nums, newIndex(left++, n), newIndex(i++, n));
                } else if (nums[newIndex(i, n)] < median) {
                    swap(nums, newIndex(right--, n), newIndex(i, n));
                } else {
                    i++;
                }
            }
        }

        private int newIndex(int index, int n) {
            return (1 + 2 * index) % (n | 1);
        }

        private void swap(int[] array, int i, int j) {
            if (i == j)
                return;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private int kthIndex(int[] nums, int index, int start, int end) {
            if (start == end) {
                assert index == 0;
                return nums[start + index];
            }
            int len = end - start + 1;
            int pivot = random.nextInt(len);
            swap(nums, start + pivot, start);
            int next = start + 1;
            for (int j = start + 1; j <= end; j++) {
                if (nums[j] <= nums[start]) {
                    swap(nums, next++, j);
                }
            }
            swap(nums, start, next - 1);
            int leftLen = next - start;
            if (index == leftLen - 1)
                return nums[next - 1];
            if (index >= leftLen) {
                return kthIndex(nums, index - leftLen, next, end);
            } else {
                return kthIndex(nums, index, start, next - 2);
            }
        }

    }

    public class Solution {
        private Random random = new Random();

        public void wiggleSort(int[] nums) {
            int umIndex = nums.length / 2;
            int um = kthIndex(nums, umIndex, 0, nums.length - 1);
            assert um == nums[umIndex];
            int[] copy = Arrays.copyOf(nums, nums.length);
            int next = copy.length - 1;
            for (int i = 1; i < copy.length; i += 2) {
                if (copy[next] == um) {
                    if (next == umIndex) {
                        nums[i] = um;
                    } else {
                        i -= 2;
                        next--;
                    }
                } else {
                    nums[i] = copy[next--];
                }
            }
            int i = copy.length % 2 == 0 ? copy.length - 2 : copy.length - 1;
            next = 0;
            for (; i >= 0; i -= 2) {
                if (copy[next] == um) {
                    if (next == umIndex) {
                        nums[i] = um;
                    } else {
                        i += 2;
                        next++;
                    }
                } else {
                    nums[i] = copy[next++];
                }
            }
        }

        private int kthIndex(int[] nums, int index, int start, int end) {
            if (start == end) {
                assert index == 0;
                return nums[start + index];
            }
            int len = end - start + 1;
            int pivot = random.nextInt(len);
            swap(nums, start + pivot, start);
            int next = start + 1;
            for (int j = start + 1; j <= end; j++) {
                if (nums[j] <= nums[start]) {
                    swap(nums, next++, j);
                }
            }
            swap(nums, start, next - 1);
            int leftLen = next - start;
            if (index == leftLen - 1)
                return nums[next - 1];
            if (index >= leftLen) {
                return kthIndex(nums, index - leftLen, next, end);
            } else {
                return kthIndex(nums, index, start, next - 2);
            }
        }

        private void swap(int[] array, int i, int j) {
            if (i == j)
                return;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public class SortingSolution {
        public void wiggleSort(int[] nums) {
            int[] copy = new int[nums.length];
            System.arraycopy(nums, 0, copy, 0, nums.length);
            Arrays.sort(copy);
            int nextIndex = nums.length - 1;
            for (int i = 1; i < nums.length; i += 2) {
                nums[i] = copy[nextIndex--];
            }
            for (int j = 0; j < nums.length; j += 2) {
                nums[j] = copy[nextIndex--];
            }
        }
    }
}
