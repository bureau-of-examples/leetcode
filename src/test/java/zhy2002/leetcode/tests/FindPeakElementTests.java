package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.findpeakelement.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FindPeakElementTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        testFindPeak(solution, new int[]{1});
        testFindPeak(solution, new int[]{1,2});
        testFindPeak(solution, new int[]{1,2,3});
        testFindPeak(solution, new int[]{1,2,3,4});
        testFindPeak(solution, new int[]{2,1});
        testFindPeak(solution, new int[]{3, 2, 1});
        testFindPeak(solution, new int[]{4, 3, 2, 1});
        testFindPeak(solution, new int[]{3, 4, 3, 2, 1});
        testFindPeak(solution, new int[]{4,5,6,7,1,3,2});
        testFindPeak(solution, new int[]{4,5,3,2,1,3,2});
        assertThat(1, equalTo(1));
    }

    private void testFindPeak(Solution solution, int[] array){

        assertThat(isPeak(array, solution.findPeakElement(array)), equalTo(true));
    }

    private boolean isPeak(int[] array, int index){
        if(array.length == 1 && index == 0)
            return true;

        if(array.length > 1){
            if(index == 0)
                return array[0] > array[1];

            if(index == array.length - 1)
                return array[index] > array[index - 1];

            return array[index] > array[index - 1] && array[index] > array[index + 1];
        }

        return false;
    }
}
