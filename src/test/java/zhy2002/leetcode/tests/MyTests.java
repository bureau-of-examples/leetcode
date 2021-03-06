package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class MyTests {

    @Test
    public void testSolve() {
        System.out.println(solve(new int[] {}));
    }

    private static String solve(int[] array) {
        Set<Integer> nums = new HashSet<>();
        for (int num : array) {
            if (nums.contains(num)) {
                nums.remove(num);
            } else {
                nums.add(num);
            }
        }
        int[] result = new int[3];
        int index = 0;
        for (int num : nums) {
            result[index++] = num;
        }

        if (result[0] <= result[1])
            return result[0] + " " + result[1];
        else
            return result[1] + " " + result[0];
    }


    @Test
    public void test6() {
        System.out.println(solve6(new int[]{1, 5, 11, 5}));
    }

    private static boolean solve6(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        if (sum == 0)
            return true;
        return canSplit(array, sum / 2);
    }

    private static boolean canSplit(int[] array, int targetSum) {
        boolean[][] dp = new boolean[targetSum+1][array.length + 1];
        dp[0][0] = true;
        for (int j=1; j<=array.length; j++) {
            int num = array[j-1];
            for (int i=0; i<=targetSum; i++) {
                if (dp[i][j-1]) {
                    dp[i][j] = true;
                    if (i + num <= targetSum) {
                        dp[i + num][j] = true;
                    }
                }
            }
        }

        return dp[targetSum][array.length];
    }

    @Test
    public void test5() {
        String val = "12345";
        System.out.println(val.substring(5, 5));
    }

    @Test
    public void test4() {
        solve(8);
    }

    private static void solve(int n) {
        List<Integer> allPrimes = getPrimes(n);
        for (int i = 0; i < allPrimes.size(); i++) {
            for (int j = 0; j < allPrimes.size(); j++) {
                if (allPrimes.get(i) * allPrimes.get(j) > n)
                    break;
                System.out.print(allPrimes.get(i));
                System.out.print(" ");
                System.out.print(allPrimes.get(j));
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 2)
            return result;
        result.add(2);
        boolean[] notPrime = new boolean[n + 1];
        double root = Math.sqrt(n);
        int i;
        for (i = 3; i <= root; i += 2) {
            if (notPrime[i])
                continue;
            result.add(i);
            for (int j = i * i; j <= n; j += 2 * i) {
                notPrime[j] = true;
            }
        }
        for (; i <= n; i += 2) {
            if (!notPrime[i]) {
                result.add(i);
            }
        }
        return result;
    }


    private static long reverse(int n) {
        long result = 0;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result |= 1L << (31 - index);
            }
            n >>>= 1;
            index++;
        }

        return result;
    }


    @Test
    public void test3() {
        rotate(new int[]{1, 2, 3, 4, 5}, 2);
        reverse(1);
    }

    private static void rotate(int[] array, int num) {
        num %= array.length;
        int groups = gcd(array.length, num);

        for (int i = 0; i < groups; i++) {
            int first = array[i];
            int to = i;
            while (true) {
                int from = (to + num) % array.length;
                if (from == i) {
                    array[to] = first;
                    break;
                }
                array[to] = array[from];
                to = from;
            }
        }

        boolean first = true;
        for (int val : array) {
            if (first) {
                first = false;
            } else {
                System.out.print(" ");
            }
            System.out.print(val);
        }
        System.out.println();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    @Test
    public void test() {
        int min = Integer.MAX_VALUE;
        for (int limit = 5; limit <= 5000; limit++) {
            min = Math.min(min, calc(limit));
        }
        System.out.println(min);
    }

    private int calc(int limit) {
        int money = 40;
        int farmer = 5;
        int target = 10000;
        int building = 0;
        int day = 0;
        while (money < target) {
            if (farmer < limit) {
                farmer += building;
                int toBuild = limit - farmer;
                toBuild = Math.min(toBuild, money / 40);
                building = toBuild;
            }
            day++;
            money += farmer * 15;
        }
        return day;
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        assertThat(solution.reversePairs(new int[]{3, 1, 2}), equalTo(2L));
        assertThat(solution.reversePairs(new int[]{2, 1}), equalTo(1L));
        assertThat(solution.reversePairs(new int[]{3, 2, 1, 4}), equalTo(3L));
    }

    public class Solution {
        private long count;
        private int[] buffer;

        public long reversePairs(int[] nums) {
            count = 0;
            buffer = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return count;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if (start >= end) //base case
                return;
            int mid = (start + end) >>> 1;
            int left = start;
            int right = mid + 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, right, end);
            //merge to buffer
            int index = start;
            while (index <= end) {
                if (left > mid) {
                    buffer[index++] = nums[right++];
                } else if (right > end) {
                    buffer[index++] = nums[left++];
                } else {
                    if (nums[left] <= nums[right]) {
                        buffer[index++] = nums[left++];
                    } else {
                        buffer[index++] = nums[right++];
                        count += mid - left + 1;
                    }
                }
            }
            System.arraycopy(buffer, start, nums, start, end + 1 - start);
        }
    }
}
