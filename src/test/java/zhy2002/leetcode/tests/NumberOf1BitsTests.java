package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.numberof1bits.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberOf1BitsTests {

    @Test
    public void comparisonTest(){

        Solution solution1 = new PartitionSolution();
        Solution solution2 = new MergeSolution();

        for(int i=-200; i<=200; i++){
            assertThat(solution1.hammingWeight(i), equalTo(solution2.hammingWeight(i)));
        }

        for(int i=Integer.MAX_VALUE - 20; i != Integer.MIN_VALUE + 20; i++){
            assertThat(solution1.hammingWeight(i), equalTo(solution2.hammingWeight(i)));
        }
    }
}
