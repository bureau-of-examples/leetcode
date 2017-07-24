package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyNew2Tests {

    @Test
    public void test() {

        assertThat(findClosest(new int[]{10, 20, 30, 40}, 0), equalTo(10));
    }

    public String removeDuplicateChars(String str) {
        int[] counts = new int[128];
        for (char ch : str.toCharArray()) {
            counts[ch]++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if(counts[ch] == 1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public int findClosest(int[] array, int target) {
        assert array.length > 0;
        int start = 0, end = array.length - 1;
        while(start <= end) {
            int mid = (start + end) >>> 1;
            if (array[mid] == target) {
                return target;
            }
            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //end start,
        Integer closest = null;
        if (start < array.length) {
            closest = array[start];
        }
        if (end >= 0) {
            if (closest == null || Math.abs(closest - target) > Math.abs(array[end] - target)) {
                closest = array[end];
            }
        }
        return closest;
    }
}
