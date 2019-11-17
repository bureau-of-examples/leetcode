package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray2Tests {

    @Test
    public void test() {
        System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDuplicates(int[] nums) {

        for (int i=0; i<nums.length; i++) {
            int targetIndex = nums[i] - 1;
            if (i == targetIndex || nums[i] < 0 || nums[targetIndex] < 0) {
                continue;
            }
            if (nums[targetIndex] == nums[i]) {
                nums[targetIndex] = -nums[targetIndex];
            } else {
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[i];
                nums[i] = temp;
                i--;
            }

        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < 0 && i == -nums[i] - 1) {
                result.add(-nums[i]);
            }
        }
        return result;
    }
}
