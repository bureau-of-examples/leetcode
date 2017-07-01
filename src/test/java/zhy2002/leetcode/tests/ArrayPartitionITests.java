package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/array-partition-i/#/description
 */
public class ArrayPartitionITests {

    @Test
    public void test() {
        assertThat(arrayPairSum(new int[] {1,4,3,2}), equalTo(4));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
     }
}
